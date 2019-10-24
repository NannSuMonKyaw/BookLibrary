package com.example.dell.booklibrary.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;

public class IntroSliderActivity extends AppCompatActivity {
    private Preference_Manager prefManager;
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            InitializeDatabase.getInstance(IntroSliderActivity.this);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent=new Intent(IntroSliderActivity.this,LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            },SPLASH_TIME_OUT);



        }
        else{
            //Intent homeIntent=new Intent(SplashLoadingActivity.this,MainActivity.class);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent=new Intent(IntroSliderActivity.this,MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            },500);

        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
    }
}
