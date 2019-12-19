package com.yufeng.autowire.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/5/24.
 */
@Component
public class TulingService {

    @Autowired
    //@Qualifier("tulingDao")
    private DaoInterface tulingDao;

    public DaoInterface getTulingDao() {
        return tulingDao;
    }

    public void setTulingDao(TulingDao tulingDao) {
        this.tulingDao = tulingDao;
    }

    @Override
    public String toString() {
        return "TulingService{" +
                "tulingDao=" + tulingDao +
                '}';
    }


}
