package com.yufeng.importanno.rule;

import com.yufeng.importanno.component.Car;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by Administrator on 2019/12/15.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar
{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry beanDefinitionRegistry)
    {
        //创建一个bean定义对象
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Car.class);

        //把bean定义对象导入到容器中
        beanDefinitionRegistry.registerBeanDefinition("car", beanDefinition);
    }
}
