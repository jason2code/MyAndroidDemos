package com.android.demos.jason.myandroiddemos.absoluteDialogFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.demos.jason.myandroiddemos.R;

/**
 * Created by xude1 on 16/6/3.
 */
public class MyDialogFragment extends AbsoluteDialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dialog_content, container, false);
        return view;
    }
}
