package com.android.demos.jason.myandroiddemos.spanableString;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

/**
 * .setMovementMethod，此方法在需要响应用户事件时使用，如点击一个电话号码就跳转到拨号页面。如果不执行这个方法是不会响应事件的，即便文本看着已经是下划线蓝色字了。
 * .Spanned.SPAN_EXCLUSIVE_EXCLUSIVE，这是在 setSpan 时需要指定的 flag，它的意义我试了很久也没试出来，睡个觉，今天早上才突然有点想法，试之，果然。它是用来标识在 Span 范围内的文本前后输入新的字符时是否把它们也应用这个效果。
 * 分别有
 * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)、
 * Spanned.SPAN_INCLUSIVE_EXCLUSIVE(前面包括，后面不包括)、
 * Spanned.SPAN_EXCLUSIVE_INCLUSIVE(前面不包括，后面包括)、
 * Spanned.SPAN_INCLUSIVE_INCLUSIVE(前后都包括)
 * <p>
 * 我自己的理解:
 * span的意思是范围的意思，那么setSpan就是指 将给定字符串指定范围的区域进行格式定义。比如 修改字体，改变颜色 等
 */
public class SpannableStringActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private TextView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string);

        TextView mTextView = null;
        SpannableString msp = null;

        mTextView = (TextView) findViewById(R.id.myTextView);

        //创建一个 SpannableString对象
        msp = new SpannableString("字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot");

        //设置字体(default,default-bold,monospace,serif,sans-serif)
        msp.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小（绝对值,单位：像素）
        msp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new AbsoluteSizeSpan(20, true), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        msp.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //0.5f表示默认字体大小的一半
        msp.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //2.0f表示默认字体大小的两倍

        //设置字体前景色
        msp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置前景色为洋红色

        //设置字体背景色
        msp.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置背景色为青色

        //设置字体样式正常，粗体，斜体，粗斜体
        msp.setSpan(new StyleSpan(Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //正常
        msp.setSpan(new StyleSpan(Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        msp.setSpan(new StyleSpan(Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //斜体
        msp.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗斜体

        //设置下划线
        msp.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置删除线
        msp.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置上下标
        msp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //下标
        msp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);   //上标

        //超级链接（需要添加setMovementMethod方法附加响应）
        msp.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //电话
        msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //邮件
        msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //网络
        msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //短信   使用sms:或者smsto:
        msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //彩信   使用mms:或者mmsto:
        msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //地图

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        msp.setSpan(new ScaleXSpan(2.0f), 49, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变

        //设置字体（依次包括字体名称，字体大小，字体样式，字体颜色，链接颜色）
//        ColorStateList csllink = null;
//        ColorStateList csl = null;
//        XmlResourceParser xppcolor = getResources().getXml(R.color.color);
//        try {
//            csl = ColorStateList.createFromXml(getResources(), xppcolor);
//        } catch (XmlPullParserException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//
//        XmlResourceParser xpplinkcolor = getResources().getXml(R.color.linkcolor);
//        try {
//            csllink = ColorStateList.createFromXml(getResources(), xpplinkcolor);
//        } catch (XmlPullParserException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        msp.setSpan(new TextAppearanceSpan("monospace", Typeface.BOLD_ITALIC, 30, csl, csllink), 51, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置项目符号
        msp.setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0, msp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色

        //设置图片
        Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        msp.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(msp);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        /***********************
         * 这里尝试一下,SpannableStringBuilder 很显然其和SpannableString的区别在于其有append方法，但是他是在API21加入的。
         * SpannableString所用的字符串是死的，构造的时候传入。
         * SpannableStringBuilder 所用的字符串可以通过append添加。
         *******************************/
        TextView textView = (TextView) findViewById(R.id.myTextView2);

        SpannableStringBuilder ssb = new SpannableStringBuilder("Hello");
        ssb.append(" world", new ForegroundColorSpan(getResources().getColor(R.color.blue)), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ssb);

        viewById = (TextView) findViewById(R.id.myTextView3);
        String waitCheck = "待核验";
        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("  ");
        sb.append(waitCheck);
        String str = sb.toString();
        int from = str.length() - waitCheck.length();
        int to = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.hotel_wait_check_color)),
                from, to, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewById.setText(spannableString);

    }


}
