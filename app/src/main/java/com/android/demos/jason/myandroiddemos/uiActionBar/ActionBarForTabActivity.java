package com.android.demos.jason.myandroiddemos.uiActionBar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_for_tab);
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
