package com.psj.shareapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.psj.shareapp.R;
import com.psj.shareapp.utils.Data;


public class RUser extends AppCompatActivity {

    private static final String TAG="Register User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruser);
    }

    public void onClickBtn(View v)
    {
        Button b=(Button)v;
        final int btnid=b.getId();
        if (btnid == R.id.reg_btn) {
            EditText editText = findViewById(R.id.setUsername);
            String user = editText.getText().toString();
            if(user.contains("4040"))
             Toast.makeText(this,R.string.alpha_usn_na,Toast.LENGTH_SHORT).show();
            else
            {Data data=new Data(getSharedPreferences(Data.SDBNAME,MODE_PRIVATE));
            data.setUserName(user);

            Intent i=new Intent(RUser.this,HomeActivity.class);

            startActivity(i);}
        }
        else
        Log.d(TAG, "Button not recognized.");
    }
}