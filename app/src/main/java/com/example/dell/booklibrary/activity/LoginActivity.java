package com.example.dell.booklibrary.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.model.User;


public class LoginActivity extends AppCompatActivity {
    EditText etuserName,etPassword;
    Button btnLogin,btnRegister;
    String userName,password;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etuserName=(EditText) findViewById(R.id.lgetUserName);
        etPassword=(EditText)findViewById(R.id.lgetPassword);
        btnRegister=(Button)findViewById(R.id.lgRegister);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Notice!!!Q!!","this is inside register");
                //Toast.makeText(LoginActivity.this, "this is inside register", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();


            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=etuserName.getText().toString();
                password=etPassword.getText().toString();
               // InitializeDatabase.getInstance(LoginActivity.this);
               // Log.i("usernamebeforeinserting",userName);
                InitializeDatabase dbHelper = InitializeDatabase.getInstance(v.getContext());
            user=dbHelper.getUserDAO().getUser(userName,password);
             if((user!=null)){
                Intent intent1=new Intent( LoginActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();


                }
                else{
                 Toast.makeText(LoginActivity.this, "UserName & Password Unmatch!! ", Toast.LENGTH_SHORT).show();
             }

               // Intent intent=new Intent( v.getContext(),MainActivity.class);
              //  v.getContext().startActivity(intent);



            }
        });

           //  finish();


    }
}
