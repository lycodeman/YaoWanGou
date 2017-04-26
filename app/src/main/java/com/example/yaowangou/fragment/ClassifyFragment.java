package com.example.yaowangou.fragment;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.GridView;

import com.example.yaowangou.R;
import com.example.yaowangou.adapter.ClassifyGvAdapter;
import com.example.yaowangou.adapter.LeftClassAdapter;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.LeftClass;
import com.example.yaowangou.bean.RightClass;
import com.example.yaowangou.bean.Teas;
import com.example.yaowangou.entity.StaticConstant;
import com.example.yaowangou.eventbus.ClossEvent;
import com.example.yaowangou.eventbus.LeftToRightEvent;
import com.example.yaowangou.interfac.ILeftClass;
import com.example.yaowangou.interfac.IRightClass;
import com.example.yaowangou.interfac.ITeas;
import com.example.yaowangou.other.RecyclerViewDivider;
import com.example.yaowangou.utils.HttpUtils;
import com.example.yaowangou.utils.LoggerUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassifyFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CLASSIFY_GV = 0;
    private static final int CLASSIFY_LEFT = 1;
    @InjectView(R.id.classify_gv)
    GridView classifyGv;
    @InjectView(R.id.classify_rv_left)
    RecyclerView classifyRvLeft;
    @InjectView(R.id.classify_rv_right)
    RecyclerView classifyRvRight;
    private String mParam1;
    private String mParam2;
    private Teas teas;
    private List<Teas.DatasBeanX.DatasBean> datas;
    private List<LeftClass.DatasBeanX.DatasBean> leftLists;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case CLASSIFY_GV:
                    datas = teas.getDatas().getDatas();
                    gvAdapter = new ClassifyGvAdapter(datas);
                    classifyGv.setAdapter(gvAdapter);
                    break;
                case CLASSIFY_LEFT:
                    leftClassAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private ClassifyGvAdapter gvAdapter;
    private LeftClass leftClass;
    private LeftClassAdapter leftClassAdapter;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    public static ClassifyFragment newInstance(String param1, String param2) {
        ClassifyFragment fragment = new ClassifyFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        ButterKnife.inject(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        /*左边class*/
        leftLists=new ArrayList<>();
        leftClassAdapter = new LeftClassAdapter(leftLists);
        LinearLayoutManager layout = new LinearLayoutManager(
                YWGApplication.CONTEXT);
        classifyRvLeft.addItemDecoration(new RecyclerViewDivider(getContext(),
                LinearLayoutManager.HORIZONTAL, 2,
                getResources().getColor(R.color.divide_gray_color)));
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        classifyRvLeft.setLayoutManager(layout);
        classifyRvLeft.setAdapter(leftClassAdapter);
        /*右边class*/

    }

    private void initData() {
        ITeas iTeas = HttpUtils.retrofitTeas(StaticConstant.HTTP_POSITION);
        Call<Teas> teas = iTeas.getTeas();
        teas.enqueue(new Callback<Teas>() {
            @Override
            public void onResponse(Call<Teas> call, Response<Teas> response) {
                ClassifyFragment.this.teas = response.body();
                handler.sendEmptyMessage(CLASSIFY_GV);
                LoggerUtils.D(ClassifyFragment.this.teas.toString());
            }

            @Override
            public void onFailure(Call<Teas> call, Throwable t) {

            }
        });
        /*获取leftclass*/
        ILeftClass iLeftClass = HttpUtils.retrofitLeftCalss(StaticConstant.HTTP_GOODSCLASS);
        Call<LeftClass> leftClassCall = iLeftClass.getLeftClass();
        leftClassCall.enqueue(new Callback<LeftClass>() {
            @Override
            public void onResponse(Call<LeftClass> call, Response<LeftClass> response) {
                leftLists.clear();
                leftLists.addAll(response.body().getDatas().getDatas());
//                ClassifyFragment.this.leftClass = response.body();
                LoggerUtils.D(leftLists.toString());
                handler.sendEmptyMessage(CLASSIFY_LEFT);
            }

            @Override
            public void onFailure(Call<LeftClass> call, Throwable t) {

            }
        });

    }

    @Subscribe
    public void refreshRightClass(LeftClass.DatasBeanX.DatasBean rightEvent){
        LoggerUtils.D(rightEvent.toString());
        refreshRight(rightEvent);
    }

    private void refreshRight(LeftClass.DatasBeanX.DatasBean rightEvent) {
        IRightClass iRightClass = HttpUtils.retrofitT(StaticConstant.HTTP_GOODSCLASS);
        Map<String,String> map=new ArrayMap<>();
        map.put("parent_id",rightEvent.getGc_id()+"");
        Call<RightClass> rightClassCall = iRightClass.getRightClass(rightEvent.getGc_id());
        rightClassCall.enqueue(new Callback<RightClass>() {
            @Override
            public void onResponse(Call<RightClass> call, Response<RightClass> response) {
                RightClass rightClass1 = response.body();
                LoggerUtils.D(rightClass1.toString());
            }

            @Override
            public void onFailure(Call<RightClass> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
