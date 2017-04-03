package com.android.demos.jason.myandroiddemos.uiAnimator;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.demos.jason.myandroiddemos.R;

public class FrameAnimActivity extends AppCompatActivity {

    private ImageView iv_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        initView();
    }

    private void initView() {
        iv_anim = (ImageView) findViewById(R.id.iv_anim);
        iv_anim.setImageResource(R.drawable.frame_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv_anim.getDrawable();
        animationDrawable.start();
    }
}
