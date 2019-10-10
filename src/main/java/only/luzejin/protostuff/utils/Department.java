package only.luzejin.protostuff.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 包名称only.luzejin.protostuff.utils
 * 类名称Department
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/4/17 18:39
 **/
@Getter
@Setter
public class Department {

    private String departMentName;

    private int persionCount;

    public Department(String departMentName,int count){
        this.departMentName = departMentName;
        this.persionCount = count;
    }
}
