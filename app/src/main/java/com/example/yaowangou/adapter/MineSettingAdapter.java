package com.example.yaowangou.adapter;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.utils.ActivityUtils;
import com.example.yaowangou.utils.LoggerUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26/026.
 */

public class MineSettingAdapter extends RecyclerView.Adapter <MineSettingAdapter.MineSettingHolder>{


    private List<String> setNames;
    private List<Integer> drawableId;

    public MineSettingAdapter(List<String> setNames, List<Integer> drawableId) {
        this.setNames = setNames;
        this.drawableId = drawableId;
        LoggerUtils.D(setNames.toString());
        LoggerUtils.D(drawableId.toString());
    }

    @Override
    public MineSettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MineSettingHolder settingHolder=new MineSettingHolder(LayoutInflater.
                from(YWGApplication.CONTEXT).
                inflate(R.layout.mine_set_item,parent,false));
        return settingHolder;
    }

    @Override
    public void onBindViewHolder(MineSettingHolder holder, int position) {
        holder.imageView.setBackgroundResource(drawableId.get(position));
        holder.textView.setText(setNames.get(position));
        holder.linearLayout.setOnClickListener(v ->
                ActivityUtils.toastShortMessege(setNames.get(position)));
    }

    @Override
    public int getItemCount() {
        return setNames.size();
    }

    public class MineSettingHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public MineSettingHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.mine_set_image);
            textView= (TextView) itemView.findViewById(R.id.mine_set_tv);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.mine_li);
        }
    }
}
