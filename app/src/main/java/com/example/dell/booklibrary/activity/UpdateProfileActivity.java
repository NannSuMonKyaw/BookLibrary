package com.example.dell.booklibrary.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;

import com.example.dell.booklibrary.fragments.AccountFragment;
import com.example.dell.booklibrary.model.User;
import com.example.dell.booklibrary.R;
public class UpdateProfileActivity extends AppCompatActivity {
String passedUserName;
TextView  etuUserName;
EditText etEmail,etPhoneNo,etAddress;
ImageView imvUserProfile;User user,updateUser;

Button btnOk;
    String strUserName,strEmail="Unknown",strPhno="Unknown",strAddress="Unknown";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        etuUserName=(TextView)findViewById(R.id.uduserName);
        etEmail=(EditText)findViewById(R.id.udemail);
        etPhoneNo=(EditText)findViewById(R.id.udphoneNo);
        etAddress=(EditText)findViewById(R.id.udaddress);
        btnOk=(Button)findViewById(R.id.btnudOk);
        imvUserProfile=(ImageView)findViewById(R.id.udUserProfile);
        passedUserName=getIntent().getExtras().getString("UserName");
        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(this);
        user=dbHelper.getUserDAO().getUserByName(passedUserName);


        strEmail=user.getEmail();
        strPhno=user.getPhoneNo();
        strAddress=user.getAddress();


        etuUserName.setText(passedUserName);
        etEmail.setText(strEmail);
        etPhoneNo.setText(strPhno);
        etAddress.setText(strAddress);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateUser=new User(etuUserName.getText().toString(),etEmail.getText().toString(),etPhoneNo.getText().toString(),etAddress.getText().toString(),null);
                dbHelper.getUserDAO().updateUserName(passedUserName,etEmail.getText().toString(),etPhoneNo.getText().toString(),etAddress.getText().toString(),null);
//                Intent intent=new Intent( v.getContext(),AccountFragment.class);
//                v.getContext().startActivity(intent);
                finish();



            }
        });

    }
}
