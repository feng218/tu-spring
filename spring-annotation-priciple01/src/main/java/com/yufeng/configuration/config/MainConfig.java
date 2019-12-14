package com.yufeng.configuration.config;

import com.yufeng.configuration.component.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/12/14.
 */
@Configuration
public class MainConfig
{
    @Bean(value = "person1")
    public Person person(){
        return new Person();
    }
}
