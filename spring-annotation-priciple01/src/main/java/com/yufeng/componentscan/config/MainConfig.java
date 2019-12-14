package com.yufeng.componentscan.config;

import com.yufeng.componentscan.config.filtertype.MyTypeFilter;
import com.yufeng.componentscan.service.TuService;
import com.yufeng.configuration.component.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2019/12/14.
 */
@Configuration

//扫描com.yufeng.componentscan包下的所有
//@ComponentScan(basePackages = {"com.yufeng.componentscan"})

//--------------排除 excludeFilters -------------
//扫描com.yufeng.componentscan包下的所有, 排除有@Controller注解的类, 排除类TuService
/*@ComponentScan(basePackages = {"com.yufeng.componentscan"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {TuService.class})})
*/

//扫描com.yufeng.componentscan包下的所有, 按照自定义规则排除
/*@ComponentScan(basePackages = {"com.yufeng.componentscan"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = {MyTypeFilter.class})})*/

//--------------包含 includeFilters -------------
@ComponentScan(basePackages = {"com.yufeng.componentscan"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {Person.class})},
        useDefaultFilters = false)

public class MainConfig
{
}
