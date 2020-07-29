package com.psj.shareapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.psj.shareapp.R;

public class HomeActivity extends AppCompatActivity {

    String KEY_NAME="TOKEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String av=getIntent().getStringExtra(KEY_NAME);
        setContentView(R.layout.activity_home);
    }
}