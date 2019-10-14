package only.luzejin.kafka;

import only.luzejin.config.kafkaCondition;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 包名称only.luzejin.kafka
 * 类名称kafkaConfig
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/25 0:26
 **/
@Configuration
@Conditional(kafkaCondition.class)
public class kafkaConfig {


    @Value("${luzejin.kafka.brokerAddress}")
    private List<String> brokerAddrs;

    @Bean
    public KafkaProducer<String,String> kafkaProducer(){
        Properties props = new Properties();
        props.put("max.request.size", 2147483647);
        props.put("buffer.memory", 2147483647);
        props.put("timeout.ms", 3000000);
        props.put("acks","1");
        props.put("request.timeout.ms", 30000000);
        props.put("bootstrap.servers", brokerAddrs);
        props.put("deserializer.encoding", "UTF-8");
        props.put("auto.offset.reset", "latest");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(props);

        return kafkaProducer;
    }


    @Bean
    public KafkaConsumer<String,String> kafkaConsumer(){
        Properties props = new Properties();
        props.put("bootstrap.servers",brokerAddrs);
        props.put("group.id","test-consumer-group");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        kafkaConsumer.subscribe(Collections.singletonList(KafkaTopic.test));
        return kafkaConsumer;

    }
}
