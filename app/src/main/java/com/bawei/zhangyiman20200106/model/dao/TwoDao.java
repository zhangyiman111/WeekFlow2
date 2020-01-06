package com.bawei.zhangyiman20200106.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:10:35
 *@Description:
 * */
@Entity
public class TwoDao {
    private String type;

    @Generated(hash = 1927387612)
    public TwoDao(String type) {
        this.type = type;
    }

    @Generated(hash = 1505278266)
    public TwoDao() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
