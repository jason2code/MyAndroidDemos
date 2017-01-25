package com.android.demos.jason.myandroiddemos.uiProgressbar;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

public class ProgressBarActivity extends AppCompatActivity {


    private static final long TIME_IN_FUTURE = 30000;
    private static final long TIME_INTERVAL = 1000;
    ViewGroup topBarProgress;
    ViewGroup topBarInfo;
    private ProgressBar progressBar;
    private TextView progressHintText;
    private TextView progressPercentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);


    }

    @Override
    protected void onStart() {
        super.onStart();
        topBarProgress = (ViewGroup) findViewById(R.id.top_bar_progress_layout);
        topBarInfo = (ViewGroup) findViewById(R.id.top_bar_info_layout);

        progressBar = (ProgressBar) topBarProgress.findViewById(R.id.top_progress_bar);
        progressHintText = (TextView) topBarProgress.findViewById(R.id.progress_hint_text);
        progressPercentNum = (TextView) topBarProgress.findViewById(R.id.progress_percent_num);
    }

    public void showProgressMode(View view) {
        topBarProgress.setVisibility(View.VISIBLE);
        topBarInfo.setVisibility(View.GONE);

        progressHintText.setText("正在努力为您占座，成功后可支付，请稍候…");

        valueAnimator();

//        CountDownTimer countDownTimer = new CountDownTimer(TIME_IN_FUTURE, TIME_INTERVAL) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                long passedtime = TIME_IN_FUTURE - millisUntilFinished;
//                int percent = getProgressPercent(passedtime);
//                //// TODO: 17/1/12 xude1 这里异步操作ui要加保护
//                setProgresBar(percent);
//            }
//
//            @Override
//            public void onFinish() {
//                //// TODO: 17/1/12 xude1 这里异步操作ui要加保护
//                setProgresBar(99);
//            }
//        };
//
//        countDownTimer.start();
    }

    private void setProgresBar(int percent) {
        progressBar.setProgress(percent);
    }

//    /**
//     * R=200/25*t-½(200/25/25)t²=8t-(4/25)t²
//     */
//    public int getProgressPercent(long time) {
//        long sec = time / 1000;
//        double percent = 8 * sec - (4 / 25) * Math.pow(sec, 2);
//        return (int) percent;
//    }

    /**
     * ValueAnimator 与 ObjectAnimator 是 父子关系，
     * ObjectAnimator 属性动画 其实很简单，就是在动画启动后，每个时间点给目标对象的属性设置相应的值，
     * 那么核心就是在某个时间点设置某个值，这个就是由ValueAnimator 来控制的。而ObjectAnimator只是对他的一次封装
     */
    public void valueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 99);
        valueAnimator.setDuration(50000);
        valueAnimator.start();
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer i = (Integer) animation.getAnimatedValue();
                setProgresBar(i);
                progressPercentNum.setText(i + "%");
            }
        });
    }

    public void showTopBarInfoMode(View view) {
        topBarProgress.setVisibility(View.GONE);
        topBarInfo.setVisibility(View.VISIBLE);

    }
}
