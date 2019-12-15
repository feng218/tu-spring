package com.yufeng.factorybean.config;

import com.yufeng.factorybean.component.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/12/15.
 */
@Configuration
public class MainConfig {
    @Bean
    public CarFactoryBean carFactoryBean() {
        return new CarFactoryBean();
    }
}
