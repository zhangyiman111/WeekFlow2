package com.bawei.zhangyiman20200106.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangyiman20200106.R;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:53
 *@Description:
 * */
public class GrAdapter extends RecyclerView.Adapter<GrAdapter.MyViewHolder> {
    private List<TwoBean.DataBean> data;

    public GrAdapter(List<TwoBean.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item2, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String goods_english_name = data.get(position).getGoods_english_name();
        holder.tv02.setText(goods_english_name);
        Glide.with(holder.img)
                .load(data.get(position).getGoods_thumb())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv02)
        TextView tv02;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
