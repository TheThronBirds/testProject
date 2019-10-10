package only.luzejin.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 包名称only.luzejin.config
 * 类名称DataSourceAop
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/3/28 22:57
 **/
@Aspect
@Component
public class DataSourceAop {

    /*@Before("execution(public * only.luzejin.Controller.testController.test(..))")
    public void setDataSource1(){
        System.out.println("数据源1");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST01);
    }

    @Before("execution(public * only.luzejin.Controller.testController.test2(..))")
    public void setDataSource2(){
        System.out.println("数据源2");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST02);
    }*/

    @Pointcut("@annotation(only.luzejin.Annotation.dynamicSourceMain)")
    public void DynamicMainAspect(){

    }

    @Before("DynamicMainAspect()")
    public void beforeMainOperation(){
        System.out.println("数据源1");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST01);
    }

    @Pointcut("@annotation(only.luzejin.Annotation.dynamicSourceSub)")
    public void DynamicSubAspect(){

    }

    @Before("DynamicSubAspect()")
    public void beforeSubOperation(){
        System.out.println("数据源2");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST02);
    }
}
