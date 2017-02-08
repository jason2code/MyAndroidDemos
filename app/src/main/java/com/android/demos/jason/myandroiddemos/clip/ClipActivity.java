package com.android.demos.jason.myandroiddemos.clip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.demos.jason.myandroiddemos.R;

public class ClipActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView clipImage;
    private Button addLevel;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        initView();
    }

    private void initView() {
        clipImage = (ImageView) findViewById(R.id.clipImage);

        addLevel = (Button) findViewById(R.id.addLevel);
        addLevel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addLevel:
                level += 500;
                clipImage.setImageLevel(level);
                break;
        }
    }
}
