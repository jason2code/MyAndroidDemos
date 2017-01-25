package com.android.demos.jason.myandroiddemos.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by xude1 on 16/6/3.
 */
public class BaseConfig {
    private static int widthPixels = 0;
    private static int heightPixels = 0;
    private static float density = 0;
    private static int densityDpi = 0;

    public static int getWidthPixels() {
        if(widthPixels == 0) {
            init();
        }
        return widthPixels;
    }

    public static int getHeightPixels() {
        if(heightPixels == 0) {
            init();
        }
        return heightPixels;
    }

    public static float getDensity() {
        if(density == 0) {
            init();
        }
        return density;
    }

    private static void init() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        heightPixels = displayMetrics.heightPixels;
        widthPixels = displayMetrics.widthPixels;
        density = displayMetrics.density;
        densityDpi = displayMetrics.densityDpi;
    }

    public static int dp2px(int dp) {
        return (int) (dp * getDensity());
    }
}
