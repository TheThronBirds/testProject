package only.luzejin;

import only.luzejin.kafka.KafkaTopic;
import only.luzejin.service.testService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.UUID;

/**
 * 包名称only.luzejin
 * 类名称ProjectApplication
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/29 12:56
 **/
@SpringBootApplication
@MapperScan(basePackages = {"only.luzejin.repository"}, annotationClass = Repository.class)
public class ProjectApplication implements CommandLineRunner {


    @Autowired
    private only.luzejin.service.testService testService;

    public static void main(String[] args) {



        SpringApplication.run(ProjectApplication.class,args);


    }

    @Override
    public void run(String... strings) throws Exception {
        /*String code = UUID.randomUUID().toString();
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>("test",code,"luzejin");
        kafkaProducer.send(producerRecord);*/
        testService.test();
    }
}
