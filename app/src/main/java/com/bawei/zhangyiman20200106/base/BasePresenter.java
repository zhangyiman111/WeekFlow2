package com.bawei.zhangyiman20200106.base;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:53
 *@Description:
 * */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
