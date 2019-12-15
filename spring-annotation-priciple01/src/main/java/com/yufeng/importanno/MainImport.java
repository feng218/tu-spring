package com.yufeng.importanno;

import com.yufeng.importanno.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/15.
 */
public class MainImport
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(name -> System.out.println("bean名字: " + name));

    }
}
