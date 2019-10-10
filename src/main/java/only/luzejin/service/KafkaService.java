package only.luzejin.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 包名称only.luzejin.service
 * 类名称KafkaService
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/29 22:53
 **/
@Slf4j
@ConditionalOnMissingBean(kafkaStream.class)
public class KafkaService {


    @Autowired
    private KafkaConsumer kafkaConsumer;


    @PostConstruct
    public void consumer(){
        log.info("开始消费记录");
        try{
            while(true){
                ConsumerRecords<String,String> consumerRecords = kafkaConsumer.poll(100);
                for(ConsumerRecord<String,String> record:consumerRecords){
                    log.info("test主题值：" + record.value());
                }
                //kafkaConsumer.commitAsync();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaConsumer.close();
        }

    }
}
