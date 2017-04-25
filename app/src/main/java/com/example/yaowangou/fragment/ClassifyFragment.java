package com.example.yaowangou.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.yaowangou.R;
import com.example.yaowangou.adapter.ClassifyGvAdapter;
import com.example.yaowangou.bean.Teas;
import com.example.yaowangou.entity.StaticConstant;
import com.example.yaowangou.interfac.ITeas;
import com.example.yaowangou.utils.HttpUtils;
import com.example.yaowangou.utils.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassifyFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CLASSIFY_GV = 0;
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
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case CLASSIFY_GV:
                    datas = teas.getDatas().getDatas();
//                    gvAdapter.notifyDataSetChanged();
                    gvAdapter = new ClassifyGvAdapter(datas);
                    classifyGv.setAdapter(gvAdapter);
                    break;
            }
        }
    };
    private ClassifyGvAdapter gvAdapter;

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
//        if (datas==null)datas=new ArrayList<>();
//        gvAdapter = new ClassifyGvAdapter(datas);
//        classifyGv.setAdapter(gvAdapter);
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
