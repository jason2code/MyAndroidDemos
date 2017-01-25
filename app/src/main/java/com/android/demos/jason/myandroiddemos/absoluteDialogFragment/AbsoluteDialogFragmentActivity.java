package com.android.demos.jason.myandroiddemos.absoluteDialogFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.utils.BaseConfig;

public class AbsoluteDialogFragmentActivity extends AppCompatActivity {
    private static final int CONST_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_dialog_fragment);
    }

    protected static Bundle buildBundle() {
        Bundle bundle = new Bundle();

        //创建dialog的时候需要的参数
        bundle.putInt(AbsoluteDialogFragment.ARG_ANIMATION, R.style.hotelplus_contacts_push_bottom);
        bundle.putInt(AbsoluteDialogFragment.ARG_GRAVITY, Gravity.BOTTOM);
        bundle.putInt(AbsoluteDialogFragment.ARG_HEIGHT, BaseConfig.getHeightPixels() * 2 / CONST_3);
        return bundle;
    }

    public void jump(View v) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.setArguments(buildBundle());
        dialog.show(getSupportFragmentManager(),"DialogTest");
    }
}
