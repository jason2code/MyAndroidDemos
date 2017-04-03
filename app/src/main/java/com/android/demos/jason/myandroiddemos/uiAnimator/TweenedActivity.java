package com.android.demos.jason.myandroiddemos.uiAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.demos.jason.myandroiddemos.R;

public class TweenedActivity extends AppCompatActivity {

    private ImageView iv_alpha_cat;
    private ImageView iv_trans_cat;
    private ImageView iv_rotate_cat;
    private ImageView iv_scale_cat;
    private ImageView iv_anims_cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened);
        initView();
    }

    private void initView() {
        iv_alpha_cat = (ImageView) findViewById(R.id.iv_alpha_cat);
        iv_alpha_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlphaCat();
            }
        });
        startAlphaCat();

        iv_trans_cat = (ImageView) findViewById(R.id.iv_trans_cat);
        Animation transCat = AnimationUtils.loadAnimation(this, R.anim.anim_trans_cat);
        iv_trans_cat.startAnimation(transCat);

        iv_rotate_cat = (ImageView) findViewById(R.id.iv_rotate_cat);
        Animation rotateCat = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_cat);
        iv_rotate_cat.startAnimation(rotateCat);

        iv_scale_cat = (ImageView) findViewById(R.id.iv_scale_cat);
        Animation scaleCat = AnimationUtils.loadAnimation(this, R.anim.anim_scale_cat);
        iv_scale_cat.startAnimation(scaleCat);

        iv_anims_cat = (ImageView) findViewById(R.id.iv_anims_cat);
        Animation animsCat = AnimationUtils.loadAnimation(this,R.anim.anims_set_cat);
        iv_anims_cat.startAnimation(animsCat);
    }

    private void startAlphaCat() {
        Animation alphaCat = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_cat);
        iv_alpha_cat.startAnimation(alphaCat);
    }
}
