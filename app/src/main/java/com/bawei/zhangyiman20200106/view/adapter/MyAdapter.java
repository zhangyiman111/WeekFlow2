package com.bawei.zhangyiman20200106.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zhangyiman20200106.R;

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
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> category;

    public MyAdapter(List<String> category) {

        this.category = category;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String s = category.get(position).toString();
        holder.tv01.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListeren.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv01)
        TextView tv01;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    onClickItemListeren onClickItemListeren;

    public void setOnClickItemListeren(MyAdapter.onClickItemListeren onClickItemListeren) {
        this.onClickItemListeren = onClickItemListeren;
    }

    public interface onClickItemListeren{
        void onClickItem(int i);
    }
}
