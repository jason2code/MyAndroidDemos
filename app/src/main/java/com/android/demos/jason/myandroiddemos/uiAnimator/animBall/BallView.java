package com.android.demos.jason.myandroiddemos.uiAnimator.animBall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xude1 on 2017/4/3.
 */

public class BallView extends View {
    /**
     * 球的颜色
     */
    private int color;

    /**
     * 球的直径
     */
    private int radius;

    /**
     * 球的位置
     */
    private BallPoint point;

    public BallView(Context context) {
        super(context);
    }

    public BallView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BallView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getColor() {
        return color;
    }

    public BallView setColor(int color) {
        this.color = color;
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public BallView setRadius(int radius) {
        this.radius = radius;
        invalidate();
        return this;
    }

    public BallPoint getPoint() {
        return point;
    }

    public BallView setPoint(BallPoint point) {
        this.point = point;
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(color);
        float x = 0;
        float y = 500;
        if (point != null) {
            x = point.x;
            y = point.y;
        }

        canvas.drawCircle(x, y, radius, paint);
    }
}
