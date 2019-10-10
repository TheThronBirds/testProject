package only.luzejin.akka;

import java.io.Serializable;

/**
 * 包名称only.luzejin.akka
 * 类名称Command
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/9/23 23:55
 **/
public class Command implements Serializable {

    private final static long serialVersionUID = 1L;

    private final String data;

    public Command(String data){
        this.data = data;
    }

    public String getData() {
        return this .data ;
    }

    @Override
    public String toString() {
        return "Command{" + "data='" + data + '\'' + '}';
    }
}
