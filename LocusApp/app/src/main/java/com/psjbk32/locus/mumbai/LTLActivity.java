package com.psjbk32.locus.mumbai;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LTLActivity extends AppCompatActivity {

    static {System.loadLibrary("afmod");}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltl);
    }

    public  native String df(String str);
}
