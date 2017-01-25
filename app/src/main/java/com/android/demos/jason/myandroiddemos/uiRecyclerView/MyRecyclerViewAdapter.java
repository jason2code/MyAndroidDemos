package com.android.demos.jason.myandroiddemos.uiRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

import java.util.List;

/**
 * Created by xude1 on 17/1/15.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    private List<String> mDatas;

    public MyRecyclerViewAdapter(Context context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * 之前listview 的viewHolder是非强制的优化措施，在这里已经被融入到基础框架中了
         * 来扩大View的重用性，只有在需要创建viewHolder的时候才会被调用，减少对findviewbyId的调用次数
         */
        View item = mInflater.inflate(R.layout.layout_recyclerview_item, null);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /**
         *  这里是 数据更新到view的地方。
         *  我觉的叫做 onBindViewHolder 不妥，ViewHolder只是一个增加view复用的工具而已
         *  onUpdateView 还差不多。
         *  其实干的事情就是根据position来找到对应的数据，然后将数据更新到ViewHolder所hold的view中。
         */

        //根据position找到数据
        String num = mDatas.get(position);

        //更新数据到ViewHolder所hold的view中
        holder.tv.setText(num);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
