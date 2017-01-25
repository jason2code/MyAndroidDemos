package com.android.demos.jason.myandroiddemos.uiViewPager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.demos.jason.myandroiddemos.R;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerIndicatorActivity extends AppCompatActivity {
    View view1, view2, view3;
    ViewPager viewPager;

    public static final int SHOW_TITLE_PAGE_INDICATOR = 1;
    public static final int SHOW_CIRCLE_PAGE_INDICATOR = 2;
    /**
     * TitlePageIndicator 和  CirclePageIndicator 是不能同时被用的，因为二者都会利用ViewPager.setOnPageChangeListener接口
     * 后面设置的会被前面设置的覆盖掉。
     */
    int showStyle = SHOW_TITLE_PAGE_INDICATOR;

    TitlePageIndicator titlePageIndicator;
    CirclePageIndicator circlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_indicator_demo);

        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        view3 = lf.inflate(R.layout.layout3, null);

        PagerAdapter pagerAdapter = new MyPagerAdapter();

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerIndicatorActivity.this, "" + position, Toast.LENGTH_SHORT);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        //*** 在使用TitlePageIndicator或CirclePageIndicator时，他们会覆盖onPageChangeListener，
        // 如果外部还对viewPager的事件感兴趣，一定要使用addOnPageChangeListener，这是添加到一个监听者list中。
        viewPager.addOnPageChangeListener(onPageChangeListener);

        switch (showStyle) {
            case SHOW_CIRCLE_PAGE_INDICATOR:
                circlePageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);
                circlePageIndicator.setViewPager(viewPager);
                circlePageIndicator.setFillColor(R.color.red);
                circlePageIndicator.setRadius(15);
                circlePageIndicator.setPageColor(R.color.lightgreen);
                break;
            case SHOW_TITLE_PAGE_INDICATOR:
                /**
                 * title内容使用的是ViewPager中PagerAdapter中的pageTitle
                 */
                titlePageIndicator = (TitlePageIndicator) findViewById(R.id.title_page_indicator);
                titlePageIndicator.setTextSize(20);
                titlePageIndicator.setTextColor(R.color.red);
                titlePageIndicator.setViewPager(viewPager);
                break;
        }
    }

    class MyPagerAdapter extends PagerAdapter implements IconPagerAdapter {
        List<View> viewList;
        List<String> titleList;

        public MyPagerAdapter() {
            viewList = new ArrayList<>();// 将要分页显示的View装入数组中
            viewList.add(view1);
            viewList.add(view2);
            viewList.add(view3);

            titleList = new ArrayList<>();
            titleList.add("First");
            titleList.add("Second");
            titleList.add("Three");
        }

        @Override
        public int getIconResId(int index) {
            return 0;
        }

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
    }
}
