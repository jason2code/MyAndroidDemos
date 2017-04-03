package com.android.demos.jason.myandroiddemos.uiAnimator.animBall;

import android.animation.TypeEvaluator;

/**
 * Created by xude1 on 2017/4/3.
 */

public class SinPointTypeEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        BallPoint start = (BallPoint) startValue;
        BallPoint end = (BallPoint) endValue;
        BallPoint newPoint = new BallPoint();
        newPoint.x = start.x + fraction * (end.x - start.x);
        newPoint.y = (float) (Math.sin(newPoint.x * Math.PI / 180) * 100) + end.y;
        return newPoint;
    }
}
