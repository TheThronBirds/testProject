package only.luzejin.config;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 包名称：only.luzejin.config
 * 类名称：rabbitmqCondition
 * 类描述：rabbitmq条件类
 * 创建人：@author luzejin
 * 创建时间：2019-12-19 16:43
 */
public class rabbitmqCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String configs = conditionContext.getEnvironment().getProperty("luzejin.config");
        if(StringUtils.isNotBlank(configs)){
            for(String config:configs.split(",")){
                if(StringUtils.equalsIgnoreCase("rabbitmq",config)){
                    return true;
                }
            }
        }
        return false;
    }
}
