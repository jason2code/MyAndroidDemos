package com.android.demos.jason.myandroiddemos.meituanRoadmap.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.demos.jason.myandroiddemos.meituanRoadmap.fragment.RoomListFullDayFragment;
import com.android.demos.jason.myandroiddemos.meituanRoadmap.fragment.RoomListHoursFragment;

/**
 * Created by xude1 on 16/6/19.
 */
public class RoomListFragmentAdapter extends FragmentPagerAdapter {
    Fragment[] fragments = new Fragment[]{RoomListFullDayFragment.newInstance(null, null), RoomListHoursFragment.newInstance(null, null)};

    public RoomListFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 这里只管返回fragment就好，不用担心会重复创建fragment，这里一点FragmentPagerAdapter
     * 已经考虑到，默认去重了
     */
    @Override
    public Fragment getItem(int position) {
        if (position > 1) {
            return fragments[1];
        }

        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
       if(position == 0) {
           return RoomListFullDayFragment.getTitle();
       }else {
           return RoomListHoursFragment.getTitle();
       }
    }
}
