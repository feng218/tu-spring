package com.yufeng.importanno.config;

import com.yufeng.importanno.component.Car;
import com.yufeng.importanno.component.Fish;
import com.yufeng.importanno.component.Person;
import com.yufeng.importanno.rule.MyImportBeanDefinitionRegistrar;
import com.yufeng.importanno.rule.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2019/12/15.
 */
@Configuration
//@Import(value = {Person.class, Car.class})
//@Import(value = {Fish.class, MyImportSelector.class})
@Import(value = {MyImportSelector.class, MyImportBeanDefinitionRegistrar.class, Person.class})
public class MainConfig {
}
