package com.android.demos.jason.myandroiddemos.uiViewPager.fragmentViewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.demos.jason.myandroiddemos.R;


public class MainTab04 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View newsLayout = inflater.inflate(R.layout.main_tab_04, container, false);
        return newsLayout;
    }

}