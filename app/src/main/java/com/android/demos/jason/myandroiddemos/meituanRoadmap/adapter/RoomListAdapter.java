package com.android.demos.jason.myandroiddemos.meituanRoadmap.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

import java.util.ArrayList;

/**
 * Created by xude1 on 16/6/20.
 */
public class RoomListAdapter extends BaseAdapter {
    ArrayList<String> items;

    public RoomListAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        ViewHolder viewHolder;
        if (convertView == null) {
            v = parent.inflate(parent.getContext(), R.layout.layout_room_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) v.findViewById(R.id.tv_title);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            v = convertView;
        }

        viewHolder.tvTitle.setText(getItem(position));

        return v;
    }

    class ViewHolder {
        public TextView tvTitle;
    }
}
