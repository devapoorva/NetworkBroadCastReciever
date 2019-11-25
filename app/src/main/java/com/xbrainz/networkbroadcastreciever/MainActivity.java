package com.xbrainz.networkbroadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xbrainz.networkbroadcastreciever.application.BaseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // ((BaseActivity)getApplication()).unRegisterReceiver();
    }
}
