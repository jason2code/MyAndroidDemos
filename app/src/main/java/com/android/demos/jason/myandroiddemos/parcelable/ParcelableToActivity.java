package com.android.demos.jason.myandroiddemos.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

public class ParcelableToActivity extends AppCompatActivity {

    public static final String PARCEL = "parcel";
    public static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_to);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra(BUNDLE);
        ParcelableDeveloper pd = b.getParcelable(PARCEL);

        TextView tv = (TextView) findViewById(R.id.content);
        tv.setText(pd.name + " 经验:" + pd.yearsOfExperience + "年 技能:" + pd.skillSet.get(0).skillname);

        String str;
        StringBuffer sb;
        StringBuilder sb2;
    }
}
