package com.android.demos.jason.myandroiddemos.uiActionBar;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.utils.UiUtils;

public class ActionBarForTabActivity extends AppCompatActivity implements ActionBar.TabListener {
    public static final int TAB_TYPE = 1;
    public static final int LIST_TYPE = 2;
    private static final int CUSTOM = 3;

    ActionBar actionBar;

    int displayType = TAB_TYPE;
//    int displayType = CUSTOM;
//    int displayType = LIST_TYPE;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_for_tab);


        /**
         * 测量状态 验证，和actionbar无关
         */
        textView = (TextView) findViewById(R.id.righttext);
        final TextView tv = (TextView) findViewById(R.id.righttext);
        final LinearLayout ll_root = (LinearLayout) findViewById(R.id.ll_root);
        tv.post(new Runnable() {
            @Override
            public void run() {
                int state = ll_root.getMeasuredState();
                UiUtils.showToast(ll_root.getContext(), "高度:" + ll_root.getMeasuredHeight() + " 宽度" + ll_root.getMeasuredWidth());
                if ((state & View.MEASURED_STATE_MASK) == View.MEASURED_STATE_TOO_SMALL) {
                    UiUtils.showToast(tv.getContext(), "挤不下了");
                }
            }
        });
        /*********************/


        actionBar = getSupportActionBar();

        switch (displayType) {
            case TAB_TYPE:
                tabActionBar();
                break;
            case CUSTOM:
                customActionBar();
                break;
            case LIST_TYPE:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.post(new Runnable() {
            @Override
            public void run() {
                int width = textView.getMeasuredWidth();
                int height = textView.getMeasuredHeight();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            int width = textView.getMeasuredWidth();
            int height = textView.getMeasuredHeight();
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        /**
         * 这里传入FragmentTransaction 其实就是希望能让你切换fragment
         */
        UiUtils.showToast(this, tab.getText().toString());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void tabActionBar() {
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
    }

    public void customActionBar() {
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
    }


}
