package only.luzejin.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

/**
 * 包名称only.luzejin.akka
 * 类名称test
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/24 0:02
 **/
@Slf4j
public class test {


    public static void main(String[] args) throws Exception {
        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        Thread.sleep(5000);

        final ActorRef actorRef = actorSystem.actorOf(Props.create(SimpleActor. class), "simple-actor");

        actorRef.tell( new Command("CMD 1" ), ActorRef.noSender());
        actorRef.tell( new Command("CMD 2" ), ActorRef.noSender());
        actorRef.tell( new Command("CMD 3" ), ActorRef.noSender());
        actorRef.tell( new Command("CMD 4" ), ActorRef.noSender());
        actorRef.tell( new Command("CMD 5" ), ActorRef.noSender());

        Thread.sleep(5000);

        log.debug( "Actor System Shutdown Starting..." );

        //actorSystem.stop();
    }
}
