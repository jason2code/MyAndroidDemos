package com.android.demos.jason.myandroiddemos.meituanRoadmap.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.meituanRoadmap.adapter.RoomListFragmentAdapter;

public class ListActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        viewPager = (ViewPager) findViewById(R.id.listviewpager);
        viewPager.setAdapter(new RoomListFragmentAdapter(getSupportFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
/**
 * 如果是下面的，即使只有两个tab不足以占据这个屏幕宽度，也会平均的占满屏幕宽度
 */
        // tabLayout.setTabMode(TabLayout.MODE_FIXED);


        /**
         * 这里addTab 并不会显示title还是会使用viewpageradapter的title
         */
//        tabLayout.addTab(tabLayout.newTab().setText("全日房"));
//        tabLayout.addTab(tabLayout.newTab().setText("钟点房"));
        tabLayout.setupWithViewPager(viewPager);
    }
}
