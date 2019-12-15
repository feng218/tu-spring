package com.yufeng.factorybean.component;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2019/12/15.
 */
public class CarFactoryBean implements FactoryBean
{
    //返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    //是否为单利
    @Override
    public boolean isSingleton() {
        return true;
    }
}
