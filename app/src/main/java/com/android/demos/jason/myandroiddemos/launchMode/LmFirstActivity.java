package com.android.demos.jason.myandroiddemos.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.demos.jason.myandroiddemos.R;

public class LmFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_main);
    }

    public void jump(View view) {
        startActivity(new Intent(this, LmSecActivity.class));
    }
}
