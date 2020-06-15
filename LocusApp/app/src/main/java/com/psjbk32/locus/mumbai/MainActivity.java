package com.psjbk32.locus.mumbai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int SPLASH_TIMEOUT=3500;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent spls_end = new Intent(MainActivity.this, com.psjbk32.locus.mumbai.HomeScreen.class);
                startActivity(spls_end);
                finish();
            }
        },SPLASH_TIMEOUT);

    }
}
