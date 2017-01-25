package com.android.demos.jason.myandroiddemos.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

public class WangErActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_er);

        TextView whatWangerDo = (TextView) findViewById(R.id.WhatWangerDo);

        Intent i = getIntent();
        whatWangerDo.setText("演唱:" + i.getStringExtra("name"));
    }
}
