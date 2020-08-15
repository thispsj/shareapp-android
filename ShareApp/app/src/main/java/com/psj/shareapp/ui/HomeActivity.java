package com.psj.shareapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.psj.shareapp.R;
import com.psj.shareapp.utils.Data;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Data data=new Data(getSharedPreferences(Data.SDBNAME,MODE_PRIVATE));
        String user= data.getUserName();
        TextView tv=findViewById(R.id.text_wlc);
        tv.setText(getString(R.string.alpha_txtres_Welcometxt,user));
    }
}