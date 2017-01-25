package com.android.demos.jason.myandroiddemos.uiViewPager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.demos.jason.myandroiddemos.R;

import java.util.ArrayList;
import java.util.List;

public class NativeViewPagerActivity extends AppCompatActivity {
    View view1, view2, view3;
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        view3 = lf.inflate(R.layout.layout3, null);

        final List<View> viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        final List<String> titleList = new ArrayList<>();
        titleList.add("First");
        titleList.add("Second");
        titleList.add("Three");

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //不要使用super.instantiateItem(container, position) 否则会抛出unsupport的异常。直接override实现就好了。
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(NativeViewPagerActivity.this, "" + position, Toast.LENGTH_SHORT);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pagerTabStrip = (PagerTabStrip) viewPager.findViewById(R.id.pager_tab_strip);
        pagerTabStrip.setTextSpacing(100);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }
}
