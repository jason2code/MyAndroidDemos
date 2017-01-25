package com.android.demos.jason.myandroiddemos.uiViewPager.fragmentViewpagerIndicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.demos.jason.myandroiddemos.R;
import com.viewpagerindicator.TabPageIndicator;

public class FragmentViewpagerIndicatorActivity extends AppCompatActivity {
    TabPageIndicator tabPageIndicator;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_viewpager_indicator);

        /**
         * 使用v4包，就得用getSupportFragmentManager,Activity就继承FragmentActivity
         */
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

        tabPageIndicator = (TabPageIndicator) findViewById(R.id.indicator);
        tabPageIndicator.setViewPager(viewPager);
    }
}
