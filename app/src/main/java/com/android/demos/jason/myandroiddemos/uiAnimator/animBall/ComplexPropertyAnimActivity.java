package com.android.demos.jason.myandroiddemos.uiAnimator.animBall;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.android.demos.jason.myandroiddemos.R;

public class ComplexPropertyAnimActivity extends AppCompatActivity {

    private FrameLayout activity_complex_property_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_property_anim);
        activity_complex_property_anim = (FrameLayout) findViewById(R.id.activity_complex_property_anim);

        BallView ballView = new BallView(this);
        activity_complex_property_anim.addView(ballView);

        ObjectAnimator colorAnim = ObjectAnimator.ofArgb(ballView, "color", Color.BLUE, Color.RED, Color.YELLOW);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);

        ObjectAnimator radiusAnim = ObjectAnimator.ofInt(ballView, "radius", 10, 20, 30, 20, 10);
        radiusAnim.setRepeatMode(ValueAnimator.REVERSE);
        radiusAnim.setRepeatCount(ValueAnimator.INFINITE);

        ObjectAnimator pointAnim = ObjectAnimator.ofObject(ballView, "point", new SinPointTypeEvaluator(), new BallPoint(0, 300), new BallPoint(500, 300));
        pointAnim.setRepeatMode(ValueAnimator.REVERSE);
        pointAnim.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.playTogether(colorAnim, radiusAnim, pointAnim);
        animatorSet.start();
    }
}
