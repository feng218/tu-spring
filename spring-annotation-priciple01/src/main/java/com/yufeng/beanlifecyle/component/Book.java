package com.yufeng.beanlifecyle.component;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2019/12/15.
 */
@Component
public class Book implements InitializingBean, DisposableBean
{
    public Book() {
        System.out.println("Book的构造方法");
    }

    @PostConstruct
    public void myInit(){
        System.out.println("Book 的标注 @PostConstruct 的方法");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("Book 的标注 @PreDestroy 的方法");
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.println("Book -- DisposableBean 销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("Book -- InitializingBean 初始化");
    }
}
