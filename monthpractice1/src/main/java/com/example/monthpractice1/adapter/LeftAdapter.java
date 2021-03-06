package com.example.monthpractice1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monthpractice1.R;
import com.example.monthpractice1.bean.CatagoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamiaomiao on 2018/2/27.
 * 图一左侧商品分类列表的适配器
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {
    private List<CatagoryBean.DataBean> list = new ArrayList<>();

    private Context context;

    public LeftAdapter(Context context, List<CatagoryBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_item, parent,false);

        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeftViewHolder holder, final int position) {
        if(po==position){
            holder.textView.setTextColor(Color.RED);
            holder.textView.setBackgroundColor(Color.parseColor("#eeeeee"));
        }else {
            holder.textView.setTextColor(Color.BLACK);
            holder.textView.setBackgroundColor(Color.WHITE);
        }
        holder.textView.setText(list.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onItemClick(v,list.get(position).getCid());
                po=position;
                notifyDataSetChanged();
            }
        });
    }
private int po=0;
    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public LeftViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.left_title);
        }
    }
    //设置条目点击事件
    private OnItemClickListner listner;
    public void setClick(OnItemClickListner listner){
        this.listner=listner;
    }
}
