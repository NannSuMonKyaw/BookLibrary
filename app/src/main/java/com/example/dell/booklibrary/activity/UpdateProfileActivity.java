package com.example.dell.booklibrary.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
int passedId;
EditText  etuUserName;
EditText etEmail,etPhoneNo,etAddress;
ImageView imvUserProfile;User user,updateUser;

Button btnOk;
    String strUserName,strEmail="Unknown",strPhno="Unknown",strAddress="Unknown";String photoPath;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        etuUserName=(EditText)findViewById(R.id.uduserName);
        etEmail=(EditText)findViewById(R.id.udemail);
        etPhoneNo=(EditText)findViewById(R.id.udphoneNo);
        etAddress=(EditText)findViewById(R.id.udaddress);
        btnOk=(Button)findViewById(R.id.btnudOk);
        imvUserProfile=(ImageView)findViewById(R.id.udUserProfile);
        passedId=getIntent().getExtras().getInt("userId");
        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(this);
        user=dbHelper.getUserDAO().getUserById(passedId);


        strEmail=user.getEmail();
        strPhno=user.getPhoneNo();
        strAddress=user.getAddress();
        photoPath=user.getPhotoPath();
        strUserName=user.getUserName();

        etuUserName.setText(strUserName);
        etEmail.setText(strEmail);
        etPhoneNo.setText(strPhno);
        etAddress.setText(strAddress);
        imvUserProfile.setImageBitmap(BitmapFactory.decodeFile(photoPath));
        imvUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.getUserDAO().updateUserName(passedId,etuUserName.getText().toString(),etEmail.getText().toString(),etPhoneNo.getText().toString(),etAddress.getText().toString(),photoPath);

                finish();



            }
        });

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
            photoPath = cursor.getString(columnIndex);
            cursor.close();

            imvUserProfile.setImageBitmap(BitmapFactory.decodeFile(photoPath));


        }


    }}
