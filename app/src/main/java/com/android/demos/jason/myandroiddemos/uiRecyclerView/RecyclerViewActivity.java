package com.android.demos.jason.myandroiddemos.uiRecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    MyRecyclerStaggeredViewAdapter staggeredViewAdapter;
    MyRecyclerStaggeredViewAdapter.OnItemClickListener itemClickListener = new MyRecyclerStaggeredViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int pos) {
            UiUtils.showToast(RecyclerViewActivity.this, "item被短击 位置:" + pos);
        }

        @Override
        public boolean onLongClick(View v, int pos) {
            UiUtils.showToast(RecyclerViewActivity.this, "item被长击 位置:" + pos);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
//        recyclerView.setAdapter(new MyRecyclerViewAdapter(this, mDatas));
        staggeredViewAdapter = new MyRecyclerStaggeredViewAdapter(this, mDatas);
        staggeredViewAdapter.setListener(itemClickListener);
        recyclerView.setAdapter(staggeredViewAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.addItemDecoration(new MyRecyclerListItemDecoration(this, MyRecyclerListItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new MyRecyclerGridItemDecoration(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                staggeredViewAdapter.addData(5);
                break;

            case R.id.menu_delete:
                staggeredViewAdapter.removeData(8);
                break;

        }
        return true;
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }


}
