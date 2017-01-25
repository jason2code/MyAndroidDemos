package com.android.demos.jason.myandroiddemos.uiViewPager.fragmentViewpagerIndicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by xude1 on 15/12/28.
 */
public class TabAdapter extends FragmentPagerAdapter {
    String titles[] = new String[]{"课程", "问答", "求课", "学习", "计划"};
    ArrayList<TabFragment> fragmentArrayList = new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment tabFragment;
        try {
            tabFragment = fragmentArrayList.get(position);
            return tabFragment;
        } catch (Exception e) {
            e.printStackTrace();
        }

        tabFragment = new TabFragment();
        tabFragment.setArguments(TabFragment.getBundle(titles[position]));
        fragmentArrayList.add(tabFragment);
        return tabFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
