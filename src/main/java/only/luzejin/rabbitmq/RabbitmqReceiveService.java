package only.luzejin.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 包名称：only.luzejin.rabbitmq
 * 类名称：RabbitmqReceiveService
 * 类描述：rabbitmq接收类
 * 创建人：@author luzejin
 * 创建时间：2019-12-19 16:51
 */
public class RabbitmqReceiveService {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${nfjj.order.queue}", durable = "true"),
            exchange = @Exchange(name = "${nfjj.order.exchange}",
                    type = "${nfjj.order.exchangeType:direct}",
                    ignoreDeclarationExceptions = "true"),
            key = {"${nfjj.order.cancel.topic}", "${nfjj.order.receive.topic}", "${nfjj.order.list.topic}"}
    ))
    private void process(){

    }
}
