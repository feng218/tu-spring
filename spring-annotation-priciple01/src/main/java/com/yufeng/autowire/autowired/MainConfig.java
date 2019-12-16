package com.yufeng.autowire.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by smlz on 2019/5/24.
 */
@Configuration
@ComponentScan(basePackages = {"com.yufeng.autowired.autowired"})
public class MainConfig {
    @Bean
    public TulingDao tulingDao() {
        TulingDao tulingDao = new TulingDao();
        tulingDao.setFlag(1);
        return tulingDao;
    }

    @Bean
    public TulingDao2 tulingDao2() {
        TulingDao2 tulingDao = new TulingDao2();
        tulingDao.setFlag(2);
        return tulingDao;
    }
}
