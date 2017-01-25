package com.android.demos.jason.myandroiddemos.saveInstance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.demos.jason.myandroiddemos.R;

public class SaveInstance2Activity extends AppCompatActivity {

    private static final String TAG = SaveInstance2Activity.class.getCanonicalName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_instance2);
        Log.d(TAG, "onCreate 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 2");
    }


}
