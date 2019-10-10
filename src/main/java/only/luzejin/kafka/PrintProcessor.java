package only.luzejin.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * 包名称only.luzejin.kafka
 * 类名称PrintProcessor
 * 类描述 打印消息processor
 * 创建人luzejin
 * 创建时间2019/10/6 22:31
 **/
@Slf4j
public class PrintProcessor implements Processor<String,String> {

    private ProcessorContext processorContext;

    private KeyValueStore<String,Long> keyValueStore;

    private Map<String,String> records = new HashMap<String,String>();

    @Override
    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;
        this.processorContext.schedule(1000, PunctuationType.WALL_CLOCK_TIME, new Punctuator() {
            @Override
            public void punctuate(long l) {
                for(Map.Entry entry:records.entrySet()){
                    String value = records.get(entry.getKey());
                    log.info("消息定时处理{}",entry.getValue());
                    value = value + "addtest";
                    processorContext.forward(entry.getKey(), value);
                    records.remove(entry.getKey());
                }
                //records.clear();
                processorContext.commit();
            }
        });
        //this.keyValueStore = (KeyValueStore<String, Long>) processorContext.getStateStore("Counts");
    }

    @Override
    public void process(String key, String value) {
        log.info("接受kafka消息,消息内容{}",value.toString());
        String newKey = "";
        if(StringUtils.isBlank(key)){
            newKey = UUID.randomUUID().toString().replace("-","");
            records.put(newKey,value);
        }else{
            records.put(key,value);
        }
    }

    @Override
    public void close() {

    }
}
