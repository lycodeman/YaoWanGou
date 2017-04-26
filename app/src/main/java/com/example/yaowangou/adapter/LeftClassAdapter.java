package com.example.yaowangou.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.LeftClass;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class LeftClassAdapter extends RecyclerView.Adapter<LeftClassAdapter.LeftClassHolder> {

    private List<LeftClass.DatasBeanX.DatasBean> leftLists;

    public LeftClassAdapter(List<LeftClass.DatasBeanX.DatasBean> leftLists) {
        this.leftLists = leftLists;
    }

    @Override
    public LeftClassAdapter.LeftClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(YWGApplication.CONTEXT).
                inflate(R.layout.left_class, parent, false);
        LeftClassHolder classHolder=new LeftClassHolder(view);
        return classHolder;
    }

    @Override
    public void onBindViewHolder(LeftClassAdapter.LeftClassHolder holder, int position) {
        LeftClass.DatasBeanX.DatasBean datasBean = leftLists.get(position);
        holder.textView.setText(datasBean.getGc_name());
        holder.textView.setOnClickListener(v -> EventBus.getDefault().post(datasBean));
    }

    @Override
    public int getItemCount() {
        if (leftLists==null||leftLists.size()<=0)return 0;
        return leftLists.size();
    }

    public Object getCurrentObject(int position){
        return leftLists.get(position);
    }

    public class LeftClassHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public LeftClassHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.left_class_tv);
        }
    }
}
