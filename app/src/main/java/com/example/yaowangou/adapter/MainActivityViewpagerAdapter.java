package com.example.yaowangou.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class MainActivityViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    public MainActivityViewpagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments!=null&&fragments.size()>0)return fragments.get(position);
        return null;
    }

    @Override
    public int getCount() {
        if (fragments!=null&&fragments.size()>0)return fragments.size();
        return 0;
    }
}
