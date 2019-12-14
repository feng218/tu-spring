package com.yufeng.componentscan;

import com.yufeng.componentscan.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/14.
 */
public class MainClass
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(name -> System.out.println("bean的自定义: " + name));
        ctx.close();
    }
}
