package com.android.demos.jason.myandroiddemos.uiAnimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.android.demos.jason.myandroiddemos.R;
import com.android.demos.jason.myandroiddemos.utils.UiUtils;


/**
 * Animation的缺点是 目标虽然移动了，但是对于该目标的点击事件却仍旧在初始的位置上，不随移动改变而改变。
 */
public class AnimatorActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        imageView = (ImageView) findViewById(R.id.icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(v.getContext(), "被点击了");
            }
        });
    }

    public void moveX(View v) {
        /**
         * ofFloat 的第一个参数也就是被移动的对象 必须有setName的public方法
         *<p> 第二个参数 translationX ，translationY是相对位移，而X,Y则是绝对坐标，
         */
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);
        objectAnimator.setDuration(1000).start();
    }

    /**
     * 水平滑动 scrollX 和 水平移动translationX 的区别是？
     * 前者是view在自身内部滑动，典型的有ScrollView。在他的坐标系中，向左移动为正
     * 后者整个View都会移动;在他的坐标系中，向右移动为正
     * <p/>
     * scrollY向上移动为正。
     */
    public void scrollX(View v) {
        String SCROLL_TYPE = "scrollX";
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(imageView, SCROLL_TYPE, 300);
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Logger.d("ScrollX:" + imageView.getScrollX());
//            }
//        });
        objectAnimator.setDuration(1000).start();
    }

    public void moveY(View v) {
//        ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F).setDuration(1000).start();
//        ObjectAnimator objectAnimator =
        ObjectAnimator.ofFloat(imageView, "translationY", -200).setDuration(1000).start();
//        objectAnimator.setInterpolator(new AccelerateInterpolator());
//        objectAnimator.setDuration(1000);
//        objectAnimator.start();
    }

    public void rotation(View v) {
        ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();
    }

    /**
     * 使用PropertyValuesHolder来实现复合动画
     */
    public static final int PROPERTY_HOLDER = 1;
    public static final int ANIMATOR_SET = 2;
    public int compositeType = ANIMATOR_SET;

    /**
     * 复合动画
     */
    public void composite(View v) {
        switch (compositeType) {
            case PROPERTY_HOLDER:
                /**
                 * android优化过，性能得到提高
                 */
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0F, 200F);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0F, 200F);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0F, 360F);
                ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(1000).start();
                break;
            case ANIMATOR_SET:
                /**
                 * 相较于 PropertyValuesHolder ，AnimatorSet 有着更丰富的功能，见下面的两个测试方法。
                 */
                AnimatorSet animatorSet = new AnimatorSet();

                ObjectAnimator a1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F);
                ObjectAnimator a2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F);
                ObjectAnimator a3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);

                animatorSet.playTogether(a1, a2, a3);
                animatorSet.setDuration(1000);
                animatorSet.start();

                break;

        }
    }

    /**
     * 顺序执行多个动画
     */
    public void sequence(View v) {
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator a1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);

        animatorSet.playSequentially(a1, a2, a3);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /**
     * 灵活组合执行多动画
     */
    public void smartComposite(View v) {
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator a1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);

        animatorSet.play(a1).with(a2);
        animatorSet.play(a3).after(a1);

        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    public int listenStyle = 1;

    /**
     * 动画事件的监听
     */
    public void listenAnim(View v) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
        objectAnimator.setDuration(1000);

        /**
         * 有两种事件的监听方式，方式1 对哪个回调感兴趣就实现哪个，而方式2则是全部，显然方式1要更优一些
         */
        if (listenStyle == 1) {
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    UiUtils.showToast(AnimatorActivity.this, "动画结束");
                }
            });
        } else if (listenStyle == 2) {
            objectAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    UiUtils.showToast(AnimatorActivity.this, "动画结束");
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

        objectAnimator.start();
    }

    /**
     * ValueAnimator 与 ObjectAnimator 是 父子关系，
     * ObjectAnimator 属性动画 其实很简单，就是在动画启动后，每个时间点给目标对象的属性设置相应的值，
     * 那么核心就是在某个时间点设置某个值，这个就是由ValueAnimator 来控制的。而ObjectAnimator只是对他的一次封装
     */
    public void valueAnimator(View v) {
        final Button btn = (Button) findViewById(R.id.btn_value_animator);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(5000);
        valueAnimator.start();
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer i = (Integer) animation.getAnimatedValue();
                btn.setText(Integer.toString(i));
            }
        });
    }
}
