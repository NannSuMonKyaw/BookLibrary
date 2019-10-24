package com.example.dell.booklibrary.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.booklibrary.DB.InitializeDatabase;

import com.example.dell.booklibrary.R;
import com.example.dell.booklibrary.activity.LoginActivity;
import com.example.dell.booklibrary.activity.UpdateProfileActivity;
import com.example.dell.booklibrary.model.User;

import static android.content.Context.MODE_PRIVATE;


public class AccountFragment extends Fragment {
    TextView tvUserName,tvEmail,tvPhno,tvAddress;
    ImageView imvPhoto;User user;Button btnEdit,btnLogout;
    String strUserName,strEmail="Unknown",strPhno="Unknown",strAddress="Unknown";
    int userId;
    final InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_account, container, false);

        tvUserName=(TextView)v.findViewById(R.id.userName);
        tvEmail=(TextView)v.findViewById(R.id.email);
        tvPhno=(TextView)v.findViewById(R.id.phoneNo);
        tvAddress=(TextView)v.findViewById(R.id.address);
        imvPhoto=(ImageView)v.findViewById(R.id.userProfile);
        btnEdit=(Button)v.findViewById(R.id.btnedit);
        btnLogout=(Button)v.findViewById(R.id.btnlogout);

        SharedPreferences sp=getActivity().getSharedPreferences("login",MODE_PRIVATE);
        userId=sp.getInt("userId",1);

        user=dbHelper.getUserDAO().getUserById(userId);

        strUserName=user.getUserName();
        strEmail=user.getEmail();
        strPhno=user.getPhoneNo();
        strAddress=user.getAddress();
        tvUserName.setText(strUserName);
        tvEmail.setText(strEmail);
        tvPhno.setText(strPhno);
        tvAddress.setText(strAddress);
        imvPhoto.setImageBitmap(BitmapFactory.decodeFile(user.getPhotoPath()));
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( v.getContext(),UpdateProfileActivity.class);
                intent.putExtra("userId",userId);
                v.getContext().startActivity(intent);


            }

        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getActivity().getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.clear();
                e.commit();

                Intent intent=new Intent(v.getContext(),LoginActivity.class);
                v.getContext().startActivity(intent);
                getActivity().finish();


            }
        });






        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        user=dbHelper.getUserDAO().getUserById(userId);
        strUserName=user.getUserName();
        strEmail=user.getEmail();
        strPhno=user.getPhoneNo();
        strAddress=user.getAddress();

        tvUserName.setText(strUserName);
        tvEmail.setText(strEmail);
        tvPhno.setText(strPhno);
        tvAddress.setText(strAddress);
        imvPhoto.setImageBitmap(BitmapFactory.decodeFile(user.getPhotoPath()));

    }
}
