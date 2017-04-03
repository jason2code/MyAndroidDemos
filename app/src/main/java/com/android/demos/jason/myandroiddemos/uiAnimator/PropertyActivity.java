package com.android.demos.jason.myandroiddemos.uiAnimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.demos.jason.myandroiddemos.R;

public class PropertyActivity extends AppCompatActivity {


    private ImageView iv_alpha_cat;
    private ImageView iv_trans_cat;
    private ImageView iv_rotate_cat;
    private ImageView iv_scale_cat;
    private ImageView iv_anims_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        initView();
    }

    private void initView() {
        iv_alpha_cat = (ImageView) findViewById(R.id.iv_alpha_cat);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(iv_alpha_cat, "alpha", 0, 0.9f);
        alphaAnimator.setDuration(1000);
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
        alphaAnimator.start();


        iv_trans_cat = (ImageView) findViewById(R.id.iv_trans_cat);
        ObjectAnimator transAnimator = ObjectAnimator.ofFloat(iv_trans_cat, "translationX", 400, 0, 300, 0, 200);
        transAnimator.setDuration(2000);
        transAnimator.setRepeatCount(ValueAnimator.INFINITE);
        transAnimator.setRepeatMode(ValueAnimator.RESTART);
        transAnimator.start();

        iv_rotate_cat = (ImageView) findViewById(R.id.iv_rotate_cat);
        iv_scale_cat = (ImageView) findViewById(R.id.iv_scale_cat);
        iv_anims_cat = (ImageView) findViewById(R.id.iv_anims_cat);
    }
}