package com.android.demos.jason.myandroiddemos.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.demos.jason.myandroiddemos.R;

public class SingleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
    }
}
