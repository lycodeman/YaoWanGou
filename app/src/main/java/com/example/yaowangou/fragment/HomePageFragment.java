package com.example.yaowangou.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.yaowangou.R;
import com.example.yaowangou.adapter.HotRvAdapter;
import com.example.yaowangou.adapter.IconRvAdapter;
import com.example.yaowangou.application.YWGApplication;
import com.example.yaowangou.bean.Banner;
import com.example.yaowangou.bean.Hot;
import com.example.yaowangou.bean.Icon;
import com.example.yaowangou.bean.Top;
import com.example.yaowangou.entity.StaticConstant;
import com.example.yaowangou.eventbus.ClossEvent;
import com.example.yaowangou.interfac.IBanner;
import com.example.yaowangou.interfac.IHot;
import com.example.yaowangou.interfac.IIcon;
import com.example.yaowangou.interfac.ITop;
import com.example.yaowangou.other.RecyclerViewDivider;
import com.example.yaowangou.utils.HttpUtils;
import com.example.yaowangou.utils.LoggerUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.shizhefei.view.indicator.BannerComponent;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.RecyclerIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final int SET_RECYLVIEW = 1;
    private final int SET_BANNER = 0;
    private static final int SET_ICON = 2;
    private static final int SET_INDICATOR = 3;
    @InjectView(R.id.homeepage_viewpager)
    ViewPager homeepageViewpager;
    @InjectView(R.id.homepage_indicator_view)
    FixedIndicatorView homepageIndicatorView;
    @InjectView(R.id.homepage_recyclerview_classify)
    RecyclerView homepageRecyclerviewClassify;
    @InjectView(R.id.homepage_add_view)
    LinearLayout homepageAddView;
    @InjectView(R.id.homepage_recyclerview_hot)
    RecyclerView homepageRecyclerviewHot;
    @InjectView(R.id.homepage_swiperefresh_layout)
    SwipeRefreshLayout homepageSwiperefreshLayout;

    private String mParam1;
    private String mParam2;
    private Banner banner;
    private Hot hot;
    private Top top;
    private ViewGroup container;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SET_BANNER:
                    addView(container);
                    break;
                case SET_RECYLVIEW:
                    initRc();
                    break;
                case SET_ICON:
                    initIcon();
                    break;
                case SET_INDICATOR:
                    datas = top.getDatas().getDatas();
                    LoggerUtils.D("================::::::::::::::::"+datas.toString());
                    indicatorViewPagerAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    private LayoutInflater inflate;
    private List<Top.DatasBeanX.DatasBean> datas = new ArrayList<>();
    private IndicatorViewPager.IndicatorViewPagerAdapter indicatorViewPagerAdapter =
            new IndicatorViewPager.IndicatorViewPagerAdapter() {

                @Override
                public int getCount() {
                    return datas.size();
                }

                //设置tab
                @Override
                public View getViewForTab(int position, View convertView, ViewGroup container) {
                    if (convertView == null) {
//                        convertView=new View(YWGApplication.CONTEXT);
                        convertView = inflate.inflate(R.layout.tab_guide, container, false);
                    }
                    return convertView;
                }

                //设置每一页
                @Override
                public View getViewForPage(int position, View convertView, ViewGroup container) {
                    if (convertView == null) {
                        convertView = new ImageView(YWGApplication.CONTEXT);
                        convertView.setLayoutParams(new FrameLayout.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.MATCH_PARENT));
                    }
                    if (datas != null) {
                        ImageView imageView = (ImageView) convertView;
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.post(() -> Glide.with(getContext()).
                                load(datas.get(position).getImage()).into(imageView));

                    }
                    return convertView;
                }

            };
    private BannerComponent bannerComponent;

    private void initIndicator() {

        bannerComponent = new BannerComponent(homepageIndicatorView, homeepageViewpager, false);
//        bannerComponent.setIndicatorScrollBar(new ColorBar());
        homepageIndicatorView.setScrollBar(new ColorBar(getActivity(), Color.WHITE,
                0, ScrollBar.Gravity.CENTENT_BACKGROUND));
        bannerComponent.setAdapter(indicatorViewPagerAdapter);
        bannerComponent.setAutoPlayTime(2000);
        bannerComponent.startAutoPlay();

    }


    private void initIcon() {
        GridLayoutManager layout = new GridLayoutManager(getContext(), 4);
//        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        homepageRecyclerviewClassify.setLayoutManager(layout);
        homepageRecyclerviewClassify.setAdapter(new IconRvAdapter(icon));
    }


    private Icon icon;

    private void initRc() {
        homepageRecyclerviewHot.addItemDecoration(new RecyclerViewDivider(getContext(),
                LinearLayoutManager.HORIZONTAL, 2,
                getResources().getColor(R.color.divide_gray_color)));
        homepageRecyclerviewHot.setLayoutManager(new LinearLayoutManager(getContext()));
        homepageRecyclerviewHot.setAdapter(new HotRvAdapter(hot));
    }


    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
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
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        this.container = container;
        ButterKnife.inject(this, view);
        inflate = LayoutInflater.from(YWGApplication.CONTEXT);
        homepageSwiperefreshLayout.setColorSchemeResources(
                R.color.green, R.color.yellow, R.color.blue, R.color.read);
        initData();
        closeRefresh();
        initIndicator();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void addView(ViewGroup container) {
        LoggerUtils.D(banner.toString());
        if (banner == null) return;
        Banner.DatasBeanX datas1 = banner.getDatas();
        List<Banner.DatasBeanX.DatasBean> datas = datas1.getDatas();
        for (int i = 0; i < datas.size(); i++) {
            View child = LayoutInflater.
                    from(YWGApplication.CONTEXT).
                    inflate(R.layout.banner, container, false);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) child.findViewById(R.id.cardview_image);
            LinearLayoutCompat.LayoutParams params =
                    new LinearLayoutCompat.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            540);
            simpleDraweeView.setLayoutParams(params);
            simpleDraweeView.setImageURI(Uri.parse(datas.get(i).getImage()));
            homepageAddView.addView(simpleDraweeView);
        }


    }

    private void closeRefresh() {
        new Thread(() -> {
            SystemClock.sleep(3000);
            homepageSwiperefreshLayout.post(() -> homepageSwiperefreshLayout.setRefreshing(true));
        });

//        homepageSwiperefreshLayout.setRefreshing(true);
    }

    private void initData() {
        /*请求banner数据*/
        IBanner iBanner = HttpUtils.retrofitIBanner(StaticConstant.HTTP_POSITION);
        Call<Banner> bannerCall = iBanner.getBanner();
        bannerCall.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {
                banner = response.body();
                handler.sendEmptyMessage(SET_BANNER);
                LoggerUtils.D(banner.toString());
            }

            @Override
            public void onFailure(Call<Banner> call, Throwable t) {

            }
        });
//        请求热门商品数据
        IHot iHot = HttpUtils.retrofitIHot(StaticConstant.HTTP_BASE);
        Call<Hot> hotCall = iHot.getHot(0, 6);
        hotCall.enqueue(new Callback<Hot>() {
            @Override
            public void onResponse(Call<Hot> call, Response<Hot> response) {
                hot = response.body();
                handler.sendEmptyMessage(SET_RECYLVIEW);
                LoggerUtils.D(hot.toString());
            }

            @Override
            public void onFailure(Call<Hot> call, Throwable t) {

            }
        });
        /*请求top数据*/
        ITop iTop = HttpUtils.retrofitTop(StaticConstant.HTTP_POSITION);
        Call<Top> topCall = iTop.getTop();
        topCall.enqueue(new Callback<Top>() {
            @Override
            public void onResponse(Call<Top> call, Response<Top> response) {
                top = response.body();
                handler.sendEmptyMessage(SET_INDICATOR);
                LoggerUtils.D(top.toString());
            }

            @Override
            public void onFailure(Call<Top> call, Throwable t) {

            }
        });
        /*请求icon数据*/
        IIcon iIcon = HttpUtils.retrofitIcon(StaticConstant.HTTP_POSITION);
        Call<Icon> iconCall = iIcon.getIcon();
        iconCall.enqueue(new Callback<Icon>() {
            @Override
            public void onResponse(Call<Icon> call, Response<Icon> response) {
                icon = response.body();
                handler.sendEmptyMessage(SET_ICON);
                LoggerUtils.D(HomePageFragment.this.icon.toString());
            }

            @Override
            public void onFailure(Call<Icon> call, Throwable t) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
