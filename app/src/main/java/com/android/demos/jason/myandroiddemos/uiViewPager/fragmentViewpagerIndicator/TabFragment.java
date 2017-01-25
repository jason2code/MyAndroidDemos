package com.android.demos.jason.myandroiddemos.uiViewPager.fragmentViewpagerIndicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.demos.jason.myandroiddemos.R;


/**
 * Created by xude1 on 15/12/28.
 */
public class TabFragment extends Fragment {
    private static final String KEY_NAME = "name";

    public static Bundle getBundle(String name) {
        Bundle b = new Bundle();
        b.putString(KEY_NAME, name);
        return b;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle b = getArguments();
        String name = b.getString(KEY_NAME);
        View v = inflater.inflate(R.layout.fragment_content_2, container, false);
        EditText tv = (EditText) v.findViewById(R.id.content_input);
        if (name != null) tv.setText(name);
        return v;
    }
}
