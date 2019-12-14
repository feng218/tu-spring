package com.yufeng.componentscan.config.filtertype;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Created by Administrator on 2019/12/14.
 */
public class MyTypeFilter implements TypeFilter
{
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException
    {
        //获取当前类的注解源信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前类的class的源信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息
        Resource resource =  metadataReader.getResource();
        System.out.println("类的路径:"+classMetadata.getClassName());
        if(classMetadata.getClassName().contains("dao")) {
            return true;  //返回true, 则需要去过滤掉, 所以类名中包含dao的类不会被加载到IOC容器中
        }
        return false;
    }
}
