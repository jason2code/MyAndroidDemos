package com.android.demos.jason.myandroiddemos.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.demos.jason.myandroiddemos.R;

import java.util.ArrayList;
import java.util.List;

public class ParcelableFromActivity extends AppCompatActivity {
    ParcelableDeveloper pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill("java"));
        pd = new ParcelableDeveloper("jason", 6, skillList, 2);
        TextView tv = (TextView) findViewById(R.id.content);
        tv.setText(pd.name + " 经验:" + pd.yearsOfExperience + "年 技能:" + pd.skillSet.get(0).skillname);
    }

    public void jump(View view) {
        Intent i = new Intent(this, ParcelableToActivity.class);

        Bundle b = new Bundle();
        b.putParcelable(ParcelableToActivity.PARCEL, pd);
        i.putExtra(ParcelableToActivity.BUNDLE, b);

        startActivity(i);
    }
}
