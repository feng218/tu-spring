package com.yufeng.conditional.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Administrator on 2019/12/14.
 */
public class MyCondition implements Condition
{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
    {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //判断容器中是否有tulingAspect的组件
        if(beanFactory.containsBean("tulingAspect")) {
            return true;
        }
        return false;
    }
}
