package com.android.demos.jason.myandroiddemos.uiRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xude1 on 17/1/15.
 */

public class MyRecyclerStaggeredViewAdapter extends RecyclerView.Adapter<MyRecyclerStaggeredViewAdapter.MyStaggeredViewHolder> {
    private LayoutInflater mInflater;
    private List<String> mDatas;
    private List<Integer> mHeights;
    private OnItemClickListener listener;

    public MyRecyclerStaggeredViewAdapter(Context context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        initRandomHeights();
    }

    /**
     * 瀑布流时生成任意高度
     */
    private void initRandomHeights() {
        mHeights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    public MyRecyclerStaggeredViewAdapter setListener(OnItemClickListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    public MyStaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mInflater.inflate(R.layout.layout_recyclerview_item, null);
        return new MyStaggeredViewHolder(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(MyStaggeredViewHolder holder, final int position) {
        String num = mDatas.get(position);

        ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
        lp.height = mHeights.get(position);

        holder.tv.setText(num);
        holder.tv.setLayoutParams(lp);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });

            holder.itemView.setLongClickable(true);
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return listener.onLongClick(v, position);
                }
            });
        }
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    class MyStaggeredViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyStaggeredViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }

    interface OnItemClickListener {
        void onItemClick(View v, int pos);

        boolean onLongClick(View v, int pos);
    }
}
