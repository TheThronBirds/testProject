package only.luzejin.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 包名称only.luzejin.config
 * 类名称kafkaCondition
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/10/14 22:40
 **/
public class kafkaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        String configs = conditionContext.getEnvironment().getProperty("luzejin.config");
        if(StringUtils.isNotBlank(configs)){
            for(String config:configs.split(",")){
                if(StringUtils.equalsIgnoreCase("kafka",config)){
                    return true;
                }
            }
        }
        return false;
    }
}
