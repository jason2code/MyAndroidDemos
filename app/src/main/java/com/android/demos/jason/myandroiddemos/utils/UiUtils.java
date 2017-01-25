package com.android.demos.jason.myandroiddemos.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xude1 on 15/12/25.
 */
public class UiUtils {

    public static void showToast(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
