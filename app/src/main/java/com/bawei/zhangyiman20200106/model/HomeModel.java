package com.bawei.zhangyiman20200106.model;

import com.bawei.zhangyiman20200106.contract.IHomeContract;
import com.bawei.zhangyiman20200106.model.bean.OneBean;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;
import com.bawei.zhangyiman20200106.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:53
 *@Description:
 * */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getOneData(MyModelCallBack myModelCallBack) {
        NetUtil.getInstance().getApi().oneBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OneBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OneBean oneBean) {
                        myModelCallBack.onOne(oneBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallBack.onOneFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getTwoData(String pash, MyModelCallBack myModelCallBack) {
        NetUtil.getInstance().getApi().twoBean(pash)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TwoBean twoBean) {
                        myModelCallBack.onTwo(twoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myModelCallBack.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
