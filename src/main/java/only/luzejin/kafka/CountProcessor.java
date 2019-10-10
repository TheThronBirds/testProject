package only.luzejin.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

/**
 * 包名称only.luzejin.kafka
 * 类名称CountProcessor
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/10/6 23:53
 **/
@Slf4j
public class CountProcessor implements Processor<String,String> {

    private ProcessorContext processorContext;

    private KeyValueStore<String,Long> keyValueStore;

    @Override
    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;

        this.processorContext.schedule(1000, PunctuationType.WALL_CLOCK_TIME, new Punctuator() {
            @Override
            public void punctuate(long l) {
                KeyValueIterator<String,Long> iter = keyValueStore.all();

                while (iter.hasNext()) {
                    KeyValue<String, Long> entry = iter.next();
                    processorContext.forward(entry.key, entry.value.toString() + "-CountProcessor");
                }

                iter.close();
                processorContext.commit();

            }
        });
        this.keyValueStore = (KeyValueStore<String, Long>) processorContext.getStateStore("Counts");
    }

    @Override
    public void process(String key, String value) {
        String[] words = value.toLowerCase().split(",");

        for (String word : words) {
            Long oldValue = this.keyValueStore.get(word);

            if (oldValue == null) {
                this.keyValueStore.put(word, 1L);
            } else {
                this.keyValueStore.put(word, oldValue + 1);
            }
        }
    }

    @Override
    public void close() {
        log.info("CountProcessor处理拓扑关闭");
    }
}
