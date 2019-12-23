package only.luzejin.service;

import lombok.extern.slf4j.Slf4j;
import only.luzejin.config.kafkaCondition;
import only.luzejin.kafka.CountProcessor;
import only.luzejin.kafka.KafkaTopic;
import only.luzejin.kafka.MyProcessor;
import only.luzejin.kafka.PrintProcessor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.state.Stores;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * 包名称only.luzejin.service
 * 类名称kafkaStream
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/10/6 14:04
 **/
@Slf4j
@Component
@Conditional(kafkaCondition.class)
public class kafkaStream implements CommandLineRunner {

    @Value("${luzejin.kafka.brokerAddress}")
    private List<String> brokerAddrs;

    public void receiveMessage(){
        log.info("开始处理消息。。。");
        Properties props = new Properties();
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,brokerAddrs);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,UUID.randomUUID().toString());
        props.put("deserializer.encoding","UTF-8");
        props.put("auto.offset.reset", "latest");
        final StreamsBuilder streamsBuilder = new StreamsBuilder();
        //streamsBuilder.stream(KafkaTopic.test).foreach();
        /*streamsBuilder.stream(KafkaTopic.test)
                .foreach((key,value)->{
                    try {
                        log.info("主题{} 收到 kafka 消息：{}",KafkaTopic.test,value);
                    }catch (Exception e ){
                        e.printStackTrace();
                        log.error("数据引擎 接收 消息失败 ：{}",e.getMessage());
                    }
                });
        /*streamsBuilder.*/


        Topology topology = streamsBuilder.build();
        topology.addSource("test-topic","test");
        topology.addProcessor("test-processor", CountProcessor::new,"test-topic");
        topology.addStateStore(Stores.keyValueStoreBuilder(
                //指定state-store的名字，运行时会自动在前面配置的STATE_DIR_CONFIG路径下创建该文件夹
                Stores.persistentKeyValueStore("Counts"),
                Serdes.String(),
                Serdes.Long())
                .withCachingEnabled(),"test-processor");
        //topology.addStateStore(Stores.inMemoryKeyValueStore("Counts"));
        //topology.addStateStore(Stores.create("COUNTS").withStringKeys().withStringValues().inMemory().build(), "PROCESS1");
        topology.addSink("test2-topic","test2","test-processor");

        final KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();
        //topology.addProcessor("MyProcessor",new MyProcessor())
    }

    @Override
    public void run(String... strings) throws Exception {
        receiveMessage();
    }
}
