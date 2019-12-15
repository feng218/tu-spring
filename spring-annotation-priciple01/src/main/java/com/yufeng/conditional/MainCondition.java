package com.yufeng.conditional;

import com.yufeng.conditional.config.ConditionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/14.
 */
public class MainCondition
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(name -> System.out.println("bean名字: " + name));
    }
}
