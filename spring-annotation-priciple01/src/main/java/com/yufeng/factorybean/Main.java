package com.yufeng.factorybean;

import com.yufeng.factorybean.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(name -> System.out.println("bean名字: " + name));
        System.out.println("--------------");

        Object bean = ctx.getBean("carFactoryBean");
        System.out.println(bean.getClass().getName());

        System.out.println("--------------");
        Object bean2 = ctx.getBean("&carFactoryBean");
        System.out.println(bean2.getClass().getName());
    }
}
