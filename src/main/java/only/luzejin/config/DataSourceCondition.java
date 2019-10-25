package only.luzejin.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 包名称：only.luzejin.config
 * 类名称：DataSourceCondition
 * 类描述：
 * 创建人：@author luzejin
 * 创建时间：2019-10-12 15:39
 */
public class DataSourceCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
