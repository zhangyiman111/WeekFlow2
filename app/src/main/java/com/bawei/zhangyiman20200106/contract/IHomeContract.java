package com.bawei.zhangyiman20200106.contract;

import com.bawei.zhangyiman20200106.model.bean.OneBean;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:53
 *@Description:
 * */
public interface IHomeContract {
    interface IView{
        void onOne(OneBean oneBean);
        void onOneFailure(Throwable throwable);

        void onTwo(TwoBean twoBean);
        void onFailure(Throwable throwable);
    }

    interface IPresenter{
        void getOneData();
        void getTwoData(String pash);
    }

    interface IModel{
        void getOneData(MyModelCallBack myModelCallBack);
        void getTwoData(String pash,MyModelCallBack myModelCallBack);

        interface MyModelCallBack{
            void onOne(OneBean oneBean);
            void onOneFailure(Throwable throwable);

            void onTwo(TwoBean twoBean);
            void onFailure(Throwable throwable);
        }
    }
}
