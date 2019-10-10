package only.luzejin.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.stereotype.Service;

/**
 * 包名称only.luzejin.kafka
 * 类名称MyProcessor
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/10/6 12:12
 **/
@Slf4j
@Service
public class MyProcessor implements Processor<String,String> {

    private ProcessorContext processorContext;

    private KeyValueStore<String, Long> kvStore;

    @Override
    @SuppressWarnings("uncheck")
    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;
        this.processorContext.schedule(1000, PunctuationType.WALL_CLOCK_TIME, new Punctuator() {
            @Override
            public void punctuate(long l) {
                KeyValueIterator<String, Long> iterator = kvStore.all();
                while (iterator.hasNext()) {
                    KeyValue<String, Long> entry = iterator.next();
                    log.info("消息定时处理{}",entry.value);
                    processorContext.forward(entry.key, entry.value.toString());
                }
                iterator.close();

                processorContext.commit();
            }
        });

        this.kvStore = (KeyValueStore<String, Long>) processorContext.getStateStore("Counts");
    }


    @Override
    public void process(String s, String line) {
        log.info("消息处理{}",line);
        String words[] = line.toLowerCase().split(",");
        for (String word : words) {
            Long oldValue = this.kvStore.get(word);

            if (oldValue == null) {
                this.kvStore.put(word, 1L);
            } else {
                this.kvStore.put(word, oldValue + 1);
            }
        }

    }

    @Override
    public void close() {

    }
}
