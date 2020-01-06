package com.bawei.zhangyiman20200106.view.activity;

import android.os.Bundle;

import com.bawei.zhangyiman20200106.R;
import com.bawei.zhangyiman20200106.base.BaseActivity;
import com.bawei.zhangyiman20200106.contract.IHomeContract;
import com.bawei.zhangyiman20200106.model.bean.OneBean;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;
import com.bawei.zhangyiman20200106.presenter.HomePresenter;
import com.bawei.zhangyiman20200106.util.NetUtil;
import com.bawei.zhangyiman20200106.view.adapter.GrAdapter;
import com.bawei.zhangyiman20200106.view.adapter.MyAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {

    @BindView(R.id.rl)
    RecyclerView rl;
    @BindView(R.id.rl2)
    RecyclerView rl2;

    @Override
    protected void initData() {

            mPresenter.getTwoData("");
            mPresenter.getOneData();

    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter ProviderPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onOne(OneBean oneBean) {
        List<String> category = oneBean.getCategory();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rl.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(category);
        rl.setAdapter(myAdapter);
        myAdapter.setOnClickItemListeren(new MyAdapter.onClickItemListeren() {
            @Override
            public void onClickItem(int i) {
                EventBus.getDefault().post(category.get(0).intern());
            }
        });
        String s = category.get(0).intern();
        mPresenter.getTwoData(s);
    }


    @Override
    public void onOneFailure(Throwable throwable) {

    }

    @Override
    public void onTwo(TwoBean twoBean) {
        List<TwoBean.DataBean> data = twoBean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        GrAdapter grAdapter = new GrAdapter(data);
        rl2.setAdapter(grAdapter);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void getData(String s){
        EventBus.getDefault().post(s);
        mPresenter.getTwoData(s);
    }
}
