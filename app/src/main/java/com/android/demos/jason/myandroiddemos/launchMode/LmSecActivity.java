package com.android.demos.jason.myandroiddemos.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.demos.jason.myandroiddemos.R;

public class LmSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lm_sec);
    }


    public void jump(View view) {
        startActivity(new Intent(this, LmThreeActivity.class));
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "LmSecActivity onNewIntent 触发", Toast.LENGTH_LONG).show();
    }
}
