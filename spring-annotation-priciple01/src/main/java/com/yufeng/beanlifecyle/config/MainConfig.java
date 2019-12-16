package com.yufeng.beanlifecyle.config;

import com.yufeng.beanlifecyle.component.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/12/15.
 */
@Configuration
@ComponentScan(basePackages = "com.yufeng.beanlifecyle")
public class MainConfig
{
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
