package com.example.yaowangou.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.example.yaowangou.R;
import com.example.yaowangou.application.YWGApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class ActivityUtils {

    public static List<Fragment> fragments=new ArrayList<>();

    public static void replaceFragment(FragmentManager manager, Fragment fragment,String tag){
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (!fragment.isAdded()){
            fragments.add(fragment);
            fragmentTransaction.add(fragment,tag);
        }
        for (int i = 0; i < fragments.size(); i++) {
            fragmentTransaction.hide(fragments.get(i));
        }
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    public static void toastLongeMessege(Object o){
        Toast.makeText(YWGApplication.CONTEXT,o.toString(),Toast.LENGTH_LONG).show();
    }

    public static void toastShortMessege(Object o) {
        Toast.makeText(YWGApplication.CONTEXT, o.toString(), Toast.LENGTH_SHORT).show();
    }

    public static View findViewById(View view,int id){
        View viewById = view.findViewById(id);
        return viewById;
    }
}
