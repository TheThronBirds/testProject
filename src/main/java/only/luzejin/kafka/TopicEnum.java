package only.luzejin.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TopicEnum {

    testTopic("test"),

    test2Topic("test2");

    private String TopicName;

}
