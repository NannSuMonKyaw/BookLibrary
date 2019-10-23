package com.example.dell.booklibrary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.activity.UpdateProfileActivity;
import com.example.dell.booklibrary.model.User;


public class AccountFragment extends Fragment {
    TextView tvUserName,tvEmail,tvPhno,tvAddress;
    ImageView imvPhoto;User user;Button btnEdit;
    String strUserName,strEmail="Unknown",strPhno="Unknown",strAddress="Unknown";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_account, container, false);
        tvUserName=(TextView)v.findViewById(R.id.rguserName);
        tvEmail=(TextView)v.findViewById(R.id.rgemail);
        tvPhno=(TextView)v.findViewById(R.id.rgphoneNo);
        tvAddress=(TextView)v.findViewById(R.id.rgaddress);
        imvPhoto=(ImageView)v.findViewById(R.id.rguserProfileImage);
        btnEdit=(Button)v.findViewById(R.id.btnedit);



        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());
        user=dbHelper.getUserDAO().getUser();
        strUserName=user.getUserName();
        strEmail=user.getEmail();
        strPhno=user.getPhoneNo();
        strAddress=user.getAddress();
        tvUserName.setText(strUserName);
        tvEmail.setText(strEmail);
        tvPhno.setText(strPhno);
        tvAddress.setText(strAddress);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( v.getContext(),UpdateProfileActivity.class);
                intent.putExtra("UserName",strUserName);
                v.getContext().startActivity(intent);


            }
        });




        return v;
    }


}
