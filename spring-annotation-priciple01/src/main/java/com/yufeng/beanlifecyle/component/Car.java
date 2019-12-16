package com.yufeng.beanlifecyle.component;

/**
 * Created by Administrator on 2019/12/15.
 */
public class Car
{
    public Car()
    {
        System.out.println("-------Car构造方法------");
    }

    public void init(){
        System.out.println("-------Car的 init() 方法------");
    }

    public void destroy() {
        System.out.println("-------Car的 destroy() 方法------");
    }
}
