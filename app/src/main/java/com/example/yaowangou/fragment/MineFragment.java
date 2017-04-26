package com.example.yaowangou.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yaowangou.R;
import com.example.yaowangou.activity.YaoWanGouActivity;
import com.example.yaowangou.adapter.MineSettingAdapter;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.eventbus.ClossEvent;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MineFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @InjectView(R.id.mine_person_image)
    SimpleDraweeView minePersonImage;
    @InjectView(R.id.mine_person_acounts)
    TextView minePersonAcounts;
    @InjectView(R.id.mine_person_messege)
    ImageView minePersonMessege;
    @InjectView(R.id.mine_change_zilaio)
    LinearLayout mineChangeZilaio;
    @InjectView(R.id.mine_tuijianma)
    LinearLayout mineTuijianma;
    @InjectView(R.id.mine_shangcheng)
    LinearLayout mineShangcheng;
    @InjectView(R.id.mine_tuangou)
    LinearLayout mineTuangou;
    @InjectView(R.id.mine_setting_list)
    RecyclerView mineSettingList;
    @InjectView(R.id.mine_back)
    ImageView mineBack;
    @InjectView(R.id.mine_erweima)
    ImageView mineErweima;
    @InjectView(R.id.mine_tuijian)
    RelativeLayout mineTuijian;
    @InjectView(R.id.mine_foot)
    RecyclerView mineFoot;
    private String mParam1;
    private String mParam2;
    private List<String> setNames;
    private List<Integer> drawableId;

    public MineFragment() {
    }

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        initData();
    }

    private void initData() {
        setNames=new ArrayList<>();
        setNames.add("店铺收藏");
        setNames.add("商品收藏");
        setNames.add("要玩币");
        setNames.add("地址管理");
        setNames.add("兑换记录");
        setNames.add("我的售后");
        setNames.add("交易投诉");
        setNames.add("设置");
        drawableId=new ArrayList<>();
        drawableId.add(R.drawable.personal_center_shops_collection_icon);
        drawableId.add(R.drawable.personal_center_commodity_collection_icon);
        drawableId.add(R.drawable.personal_center_yaowg_icon);
        drawableId.add(R.drawable.personal_center_add_managemen_icon);
        drawableId.add(R.drawable.personal_center_exchange_record_icon);
        drawableId.add(R.drawable.personal_center_my_quality_icon);
        drawableId.add(R.drawable.personal_center_transaction_complaint_icon);
        drawableId.add(R.drawable.personal_center_set_up_icon);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, view);
        mineSettingList.setLayoutManager(
                new GridLayoutManager(YWGApplication.CONTEXT,4,GridLayoutManager.VERTICAL,false));
        mineSettingList.setAdapter(new MineSettingAdapter(setNames,drawableId));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
