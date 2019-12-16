package com.yufeng.autowire.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/5/24.
 */
@Component
public class TulingService {

    @Autowired
    private DaoInterface tulingDao1;

    public DaoInterface getTulingDao() {
        return tulingDao1;
    }

    public void setTulingDao(TulingDao tulingDao) {
        this.tulingDao1 = tulingDao;
    }

    @Override
    public String toString() {
        return "TulingService{" +
                "tulingDao=" + tulingDao1 +
                '}';
    }


}
