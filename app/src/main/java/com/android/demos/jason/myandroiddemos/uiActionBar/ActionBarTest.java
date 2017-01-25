package com.android.demos.jason.myandroiddemos.uiActionBar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.utils.UiUtils;


/**
 * Action Bar是android3.0一个重要的内容，Action Bar主要是用于代替传统的标题栏，对于Android平板设备来说屏幕更大它的标题使用Action Bar来设计可以展示更多丰富的内容，方便操控。
 * <h3>
 * Action Bar主要功能包含:<h3/>
 * 1. 显示选项菜单
 * 2. 提供标签页的切换方式的导航功能，可以切换多个fragment.
 * 3. 提供下拉的导航条目.
 * 4. 提供交互式活动视图代替选项条目
 * 5. 使用程序的图标作为返回Home主屏或向上的导航操作。
 * <p>
 * 3.0开始后，android 不再要求手机厂商添加menu按钮，而是将menu移到了标题栏，我觉的可以类比于PC上的工具栏
 * <h3>问题<h3/>
 * <p>1.貌似都得点击右边三个点然后才出现菜单
 * <p>2.使用actionViewClass，actionLayout 都没有任何作用 只显示title
 * <p>
 * 用的都是自身的接口
 * <p>
 * setHomeButtonEnabled这个小于4.0版本的默认值为true的。但是在4.0及其以上是false，该方法的作用：决定左上角的图标是否可以点击。没有向左的小图标。 true 图标可以点击  false 不可以点击。
 * actionBar.setDisplayHomeAsUpEnabled(true)    // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
 * actionBar.setDisplayShowHomeEnabled(true)   //使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
 * actionBar.setDisplayShowCustomEnabled(true)  // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
 * actionBar.setDisplayShowTitleEnabled(true)   //对应ActionBar.DISPLAY_SHOW_TITLE。
 * 其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，如果setHomeButtonEnabled设成false，即使setDisplayShowHomeEnabled设成true，图标也不能点击
 */
public class ActionBarTest extends AppCompatActivity {
    ActionBar actionBar;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);

        /**
         * 这里有说明为什么会为空 http://stackoverflow.com/questions/6867076/getactionbar-returns-null
         * 其中一个答案就是用v7的actionBar配getSupportActionBar()方法
         *
         * 如果在Manifest.xml中对应Activity设置了android:theme="@style/AppTheme.NoActionBar",那么就会返回null;
         */
        actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.tools);

        /**
         * 在左上角会不会显示一个该activity的actionBar名称，如果没有设置的话，就显示activity的名称
         */
        actionBar.setTitle("hello world");//这些可以在manifest中设置的
//        actionBar.setDisplayShowTitleEnabled(true);

        // 设置是否显示图标
        actionBar.setIcon(R.drawable.tools);     //这些可以在manifest中设置的
        actionBar.setDisplayShowHomeEnabled(true);////使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
        actionBar.setDisplayHomeAsUpEnabled(false);//actionBar.setDisplayHomeAsUpEnabled(true)    // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        actionBar.setHomeButtonEnabled(false); //setHomeButtonEnabled这个小于4.0版本的默认值为true的。但是在4.0及其以上是false，该方法的作用：决定左上角的图标是否可以点击。没有向左的小图标。 true 图标可以点击  false 不可以点击。

        /**
         * 将应用程序图标设置为可点击的按钮，并在图标上添加向左箭头
         * 该左箭头就相当于返回上个页面的退出健
         */
        actionBar.setDisplayHomeAsUpEnabled(true);

        aSwitch = (Switch) findViewById(R.id.showOrDisappear);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    actionBar.show();
                } else {
                    actionBar.hide();
                }
            }
        });
    }

    /**
     * 这里根据menu资源目录中的xml文件来实例需要在actionBar上显示的组件
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                UiUtils.showToast(this, "点击了home键");
                break;
            case R.id.item2_1:
                UiUtils.showToast(this, "点击 2.1");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}