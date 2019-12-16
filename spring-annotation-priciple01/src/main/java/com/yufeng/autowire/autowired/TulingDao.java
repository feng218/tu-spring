package com.yufeng.autowire.autowired;


import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/5/24.
 */
@Component
public class TulingDao implements DaoInterface {

    private int flag=1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TulingDao{" +
                "flag=" + flag +
                '}';
    }
}
