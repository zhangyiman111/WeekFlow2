package com.bawei.zhangyiman20200106.presenter;

import com.bawei.zhangyiman20200106.base.BasePresenter;
import com.bawei.zhangyiman20200106.contract.IHomeContract;
import com.bawei.zhangyiman20200106.model.HomeModel;
import com.bawei.zhangyiman20200106.model.bean.OneBean;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:53
 *@Description:
 * */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getOneData() {
        homeModel.getOneData(new IHomeContract.IModel.MyModelCallBack() {
            @Override
            public void onOne(OneBean oneBean) {
                view.onOne(oneBean);
            }

            @Override
            public void onOneFailure(Throwable throwable) {
                view.onOneFailure(throwable);
            }

            @Override
            public void onTwo(TwoBean twoBean) {
                view.onTwo(twoBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }

    @Override
    public void getTwoData(String pash) {
        homeModel.getTwoData(pash, new IHomeContract.IModel.MyModelCallBack() {
            @Override
            public void onOne(OneBean oneBean) {
                view.onOne(oneBean);
            }

            @Override
            public void onOneFailure(Throwable throwable) {
                view.onOneFailure(throwable);
            }

            @Override
            public void onTwo(TwoBean twoBean) {
                view.onTwo(twoBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
