package com.example.yaowangou.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.Teas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public class ClassifyGvAdapter extends BaseAdapter {
    private final List<Teas.DatasBeanX.DatasBean> datas;
    private Teas teas;

    public ClassifyGvAdapter(List<Teas.DatasBeanX.DatasBean> datas) {
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        if (datas.size()>0)return null;
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView= LayoutInflater.from(YWGApplication.CONTEXT).
                    inflate(R.layout.classify_gv_item,parent,false);
//            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT);
//            convertView.setLayoutParams(params);
        }
        ImageView imageView= (ImageView) convertView;
        Glide.with(YWGApplication.CONTEXT).load(datas.get(position).getImage()).into(imageView);
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
//        notifyDataSetChanged();
    }
}
