package com.android.demos.jason.myandroiddemos.uiAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.uiAnimator.animBall.ComplexPropertyAnimActivity;

public class AnimMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtFrameAnim;
    private Button mBtTweenAnim;
    private Button mBtPropertyAnim;
    private Button bt_complex_property_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();
    }

    private void initView() {
        mBtFrameAnim = (Button) findViewById(R.id.bt_frame_anim);
        mBtTweenAnim = (Button) findViewById(R.id.bt_tween_anim);
        mBtPropertyAnim = (Button) findViewById(R.id.bt_property_anim);
        bt_complex_property_anim = (Button) findViewById(R.id.bt_complex_property_anim);

        mBtFrameAnim.setOnClickListener(this);
        mBtTweenAnim.setOnClickListener(this);
        mBtPropertyAnim.setOnClickListener(this);
        bt_complex_property_anim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_frame_anim:
                startActivity(new Intent(this, FrameAnimActivity.class));
                break;
            case R.id.bt_tween_anim:
                startActivity(new Intent(this, TweenedActivity.class));
                break;
            case R.id.bt_property_anim:
                startActivity(new Intent(this, PropertyActivity.class));
                break;
            case R.id.bt_complex_property_anim:
                startActivity(new Intent(this, ComplexPropertyAnimActivity.class));
                break;
        }
    }
}
