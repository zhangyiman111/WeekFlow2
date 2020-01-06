package com.bawei.zhangyiman20200106.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:10:34
 *@Description:
 * */
@Entity
public class OneDao {
    public String name;

    @Generated(hash = 429578031)
    public OneDao(String name) {
        this.name = name;
    }

    @Generated(hash = 1445104211)
    public OneDao() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
