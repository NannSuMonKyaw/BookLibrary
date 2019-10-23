package com.example.dell.booklibrary.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.fragments.AboutFragment;
import com.example.dell.booklibrary.fragments.AccountFragment;
import com.example.dell.booklibrary.fragments.HomeFragment;
import com.example.dell.booklibrary.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //initialize database
        InitializeDatabase.getInstance(MainActivity.this);
        //setting the title
        toolbar.setTitle("Book Library");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;



            case R.id.navigation_dashboard:
                fragment = new AccountFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new AboutFragment();
                break;

        }
        return loadFragment(fragment);
    };
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
