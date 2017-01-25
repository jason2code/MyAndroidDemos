package com.android.demos.jason.myandroiddemos.uiViewPager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.demos.jason.myandroiddemos.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerWeiboActivity extends AppCompatActivity {
    View view1, view2, view3;
    ViewPager viewPager;
    ImageView ivIndex;

    int indexViewWidth;
    /**
     * 滑块边上的空白宽度
     */
    int offset;

    int lastPosition = 0;

    int space = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo_view_pager);

        initIndexView();

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
                Toast.makeText(ViewPagerWeiboActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                TranslateAnimation translateAnimation = new TranslateAnimation(space * lastPosition, space * position, 0, 0);
                translateAnimation.setFillAfter(true);
                ivIndex.startAnimation(translateAnimation);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    void initIndexView() {
        ivIndex = (ImageView) findViewById(R.id.index_view);
        indexViewWidth = BitmapFactory.decodeResource(getResources(), R.drawable.index_pic).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        space = screenW / 3;
        offset = (space - indexViewWidth) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        ivIndex.setImageMatrix(matrix);// 设置动画初始位置
    }
}
