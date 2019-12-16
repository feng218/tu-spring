package com.yufeng.autowire.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by smlz on 2019/5/24.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        TulingService tulingService = ctx.getBean(TulingService.class);
        System.out.println(tulingService.toString());
    }
}
