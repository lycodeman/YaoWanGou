package com.example.yaowangou.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.yaowangou.R;
import com.example.yaowangou.adapter.MainActivityViewpagerAdapter;
import com.example.yaowangou.fragment.ClassifyFragment;
import com.example.yaowangou.fragment.HomePageFragment;
import com.example.yaowangou.fragment.MineFragment;
import com.example.yaowangou.fragment.ShoppingCartFragment;
import com.example.yaowangou.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class YaoWanGouActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    @InjectView(R.id.main_activity_viewpager)
    ViewPager mainActivityViewpager;
    @InjectView(R.id.main_activity_bottom_navigationbar)
    BottomNavigationBar mainActivityBottomNavigationbar;
    @InjectView(R.id.actionbar_tv_tuijian)
    TextView actionbarTvTuijian;
    @InjectView(R.id.actionbar_cardview)
    CardView actionbarCardview;
    @InjectView(R.id.actionbar_tv_xiaoxi)
    TextView actionbarTvXiaoxi;
    @InjectView(R.id.main_toolbar)
    Toolbar mainToolbar;
    private List<Fragment> fragments = new ArrayList<>();
    private int lastPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_wan_gou);
        ButterKnife.inject(this);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        initFragment();
        initNavigationBar();
        initViewpager();
    }

    private void initViewpager() {
    /*初始化viewpager*/
        mainActivityViewpager.setAdapter(new MainActivityViewpagerAdapter(getSupportFragmentManager(), fragments));
        mainActivityViewpager.setOnPageChangeListener(this);
    }

    private void initNavigationBar() {
    /*初始化navigationbar*/
        mainActivityBottomNavigationbar.
                setMode(BottomNavigationBar.MODE_FIXED).
                setBackgroundStyle(BottomNavigationBar.MODE_DEFAULT).
                setBarBackgroundColor(R.color.navigationbar).
                addItem(new BottomNavigationItem(R.drawable.navigationbar_home_selector, R.string.navigationbar_home_page)).
                addItem(new BottomNavigationItem(R.drawable.navigationbar_shopping_selector, R.string.navigationbar_classify)).
                addItem(new BottomNavigationItem(R.drawable.navigation_bar_cart_selector, R.string.navigationbar_shopping_cart)).
                addItem(new BottomNavigationItem(R.drawable.navigationbar_my_selector, R.string.navigationbar_mine)).
                setFirstSelectedPosition(0).
                initialise();
        mainActivityBottomNavigationbar.setTabSelectedListener(this);
    }

    private List<Fragment> initFragment() {
        ClassifyFragment classifyFragment = ClassifyFragment.newInstance("", "");
        HomePageFragment homePageFragment = HomePageFragment.newInstance("", "");
        MineFragment mineFragment = MineFragment.newInstance("", "");
        ShoppingCartFragment shoppingCartFragment = ShoppingCartFragment.newInstance("", "");
        fragments.add(homePageFragment);
        fragments.add(classifyFragment);
        fragments.add(shoppingCartFragment);
        fragments.add(mineFragment);
        return fragments;
    }

    //bottomnavigationbar监听
    @Override
    public void onTabSelected(int position) {
        mainActivityViewpager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /*viewpager监听*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mainActivityBottomNavigationbar.selectTab(position, false);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick({R.id.actionbar_tv_tuijian, R.id.actionbar_cardview, R.id.actionbar_tv_xiaoxi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actionbar_tv_tuijian:
                ActivityUtils.toastShortMessege("推荐");
                break;
            case R.id.actionbar_cardview:
                ActivityUtils.toastShortMessege("搜索");
                break;
            case R.id.actionbar_tv_xiaoxi:
                ActivityUtils.toastShortMessege("消息");
                break;
        }
    }
}
