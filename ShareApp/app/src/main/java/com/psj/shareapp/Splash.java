package com.psj.shareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    int TRANS_TIME=3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String KEY="TOKEN";
                String VALUE=encodeToken("home=splash");
                Intent i=new Intent();
                i.putExtra(KEY,VALUE);
            }
        },TRANS_TIME);
    }

    public native String encodeToken(String s);
}