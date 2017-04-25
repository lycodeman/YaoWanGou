package com.example.yaowangou.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.Icon;
import com.example.yaowangou.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/22/022.
 */

public class IconRvAdapter extends RecyclerView.Adapter<IconRvAdapter.IconRvHolder> {

    private final List<Icon.DatasBeanX.DatasBean> datas;
    private Icon icon;
    private List<Integer> icons=new ArrayList<>();

    public IconRvAdapter(Icon icon) {
        this.icon = icon;
        datas = icon.getDatas().getDatas();
        datas.remove(0);
        addImages();
    }

    private void addImages() {
        icons.clear();
        icons.add(R.drawable.homepage_icon_mall_restaurant_change);
        icons.add(R.drawable.homepage_icon_pinkage_change);
        icons.add(R.drawable.homepage_icon_activity_zone_change);
        icons.add(R.drawable.homepage_icon_ywb_shopping_mall_change);
    }

    @Override
    public IconRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(YWGApplication.CONTEXT).
                inflate(R.layout.icon_rv_item, parent, false);
        IconRvHolder iconRvHolder=new IconRvHolder(inflate);
        return iconRvHolder;
    }

    @Override
    public void onBindViewHolder(IconRvHolder holder, int position) {
        holder.title.setText(datas.get(position).getTitle());
        Glide.with(YWGApplication.CONTEXT).load(icons.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (datas!=null&&datas.size()>0)
            return icons.size();
        return 0;
    }

    public class IconRvHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView imageView;
        public IconRvHolder(View itemView) {
            super(itemView);
            title= (TextView) ActivityUtils.findViewById(itemView,R.id.icon_rv_title);
            imageView= (ImageView) ActivityUtils.findViewById(itemView,R.id.icon_rv_image);
        }
    }
}
