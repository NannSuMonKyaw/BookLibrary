package com.example.dell.booklibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.model.User;


public class RegisterActivity extends AppCompatActivity {
   EditText etUserName,etPassword;
    EditText etEmail,etPhoneNo,etAddress;
    String picturePath="";
    Button btnRegister;
    ImageView imvUserProfile;
    String strUserName,strEmail,strPhno,strAddress,strPassword;
    User user;

    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUserName=(EditText)findViewById(R.id.rguserName);
        etPassword=(EditText)findViewById(R.id.rgPassword);
        etEmail=(EditText)findViewById(R.id.rgemail);
        etPhoneNo=(EditText)findViewById(R.id.rgphoneNo);
        etAddress=(EditText)findViewById(R.id.rgaddress);
        imvUserProfile=(ImageView)findViewById(R.id.rguserProfileImage);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        strUserName=etUserName.getText().toString();
        strPassword=etPassword.getText().toString();
        strEmail=etEmail.getText().toString();
        strPhno=etPhoneNo.getText().toString();
        strAddress=etAddress.getText().toString();




        imvUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        user=new User(strUserName,strPassword,strEmail,strPhno,strAddress,picturePath);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializeDatabase dbHelper = InitializeDatabase.getInstance(v.getContext());
                dbHelper.getUserDAO().insert(user);
                Intent intent=new Intent( RegisterActivity.this,MainActivity.class);
                v.getContext().startActivity(intent);
                finish();
            }
        });


        //finish();



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
             picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.rguserProfileImage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }


    }

}