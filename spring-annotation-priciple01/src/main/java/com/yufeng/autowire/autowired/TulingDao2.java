package com.yufeng.autowire.autowired;

/**
 * Created by Administrator on 2019/12/15.
 */
public class TulingDao2 implements DaoInterface
{
    private int flag=2;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TulingDao2{" +
                "flag=" + flag +
                '}';
    }
}
