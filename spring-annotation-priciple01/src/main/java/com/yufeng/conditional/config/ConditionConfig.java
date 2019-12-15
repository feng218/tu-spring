package com.yufeng.conditional.config;

import com.yufeng.conditional.component.TulingAspect;
import com.yufeng.conditional.component.TulingLog;
import com.yufeng.conditional.condition.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/12/14.
 */
@Configuration
public class ConditionConfig
{
    //当前容器中有tulingAspect的组件，那么tulingLog才会被实例化
    @Bean
    @Conditional(value = MyCondition.class)
    public TulingLog tulingLog() {
        return new TulingLog();
    }

    @Bean
    public TulingAspect tulingAspect() {
        return new TulingAspect();
    }
}
