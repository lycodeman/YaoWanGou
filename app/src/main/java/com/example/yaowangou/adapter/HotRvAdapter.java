package com.example.yaowangou.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.Hot;
import com.example.yaowangou.utils.ActivityUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21/021.
 */

public class HotRvAdapter extends RecyclerView.Adapter<HotRvAdapter.HotRvHolder> {

    private final List<Hot.DatasBeanX.DatasBean> datas;
    private Hot hot;

    public HotRvAdapter(Hot hot) {
        this.hot = hot;
        Hot.DatasBeanX datas = hot.getDatas();
        this.datas = datas.getDatas();
    }

    @Override
    public HotRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.
                from(YWGApplication.CONTEXT).
                inflate(R.layout.hot_rv_item, parent, false);
        HotRvHolder hotRvHolder=new HotRvHolder(inflate);
        return hotRvHolder;
    }

    @Override
    public void onBindViewHolder(HotRvHolder holder, int position) {
        Hot.DatasBeanX.DatasBean datasBean = datas.get(position);
        holder.tvTitle.setText(datasBean.getGoods_name());
        holder.tvNum.setText(datasBean.getYaowanbi()+"");
        holder.tvPrice.setText(datasBean.getGoods_price());
        holder.tvSales.setText(datasBean.getGoods_salenum());
        Glide.with(YWGApplication.CONTEXT).
                load(datasBean.getGoods_image()).into(holder.hotImage);
    }

    @Override
    public int getItemCount() {
        if (datas!=null&&datas.size()>0)return datas.size();
        return 0;
    }

    public class HotRvHolder extends RecyclerView.ViewHolder{

        public ImageView hotImage;
        public TextView tvNum;
        public TextView tvPrice;
        public TextView tvTitle;
        public TextView tvSales;

        public HotRvHolder(View itemView) {
            super(itemView);
            hotImage = (ImageView) ActivityUtils.findViewById(itemView, R.id.hot_rv_imag);
            tvNum = (TextView) ActivityUtils.findViewById(itemView, R.id.hot_tv_num);
            tvPrice = (TextView) ActivityUtils.findViewById(itemView, R.id.hot_tv_price);
            tvTitle = (TextView) ActivityUtils.findViewById(itemView, R.id.hot_tv_title);
            tvSales = (TextView) ActivityUtils.findViewById(itemView, R.id.hot_tv_sales);
        }
    }
}
