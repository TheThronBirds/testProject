package only.luzejin.akka;

import akka.actor.AbstractActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 包名称only.luzejin.akka
 * 类名称SimpleActor
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/23 23:41
 **/
@Slf4j
public class SimpleActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Command.class,message->handMessagehandler(message))
                .matchAny(message -> {
                    log.warn("无法处理的消息");
                }).build();
    }


    public SimpleActor() {
        log.info( "SimpleActor constructor");
    }

    private void handMessagehandler(Command message){
        log.info("收到消息"  + message.toString());
    }

}
