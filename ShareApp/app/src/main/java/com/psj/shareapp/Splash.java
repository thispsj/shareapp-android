package com.psj.shareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.psj.shareapp.utils.http.SAHS;

public class Splash extends AppCompatActivity {

    int TRANS_TIME=3500;
    private final String sharedPrefName="com.psj.shareapp";
    private final String USER_KEY="User.name0";
    private final String GEKEY[]={"usr","spdb"};

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