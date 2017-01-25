package com.android.demos.jason.myandroiddemos.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.demos.jason.myandroiddemos.R;

public class LmThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lm_three);
    }

    public void jumpSecWithSingleTask(View view) {
        Intent i = new Intent(this, LmSecActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //似乎并不起到作用
        startActivity(i);
    }

    public void jumpThreeWithSingleTop(View view) {
        Intent i = new Intent(this, LmThreeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
    }

    public void jumpThreeWithStandard(View view) {
        Intent i = new Intent(this, LmThreeActivity.class);
        startActivity(i);
    }
    public void jumpSingleInstance(View view) {
        Intent i = new Intent(this, SingleInstanceActivity.class);
        startActivity(i);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "LmThreeActivity onNewIntent 触发", Toast.LENGTH_LONG).show();
    }
}
