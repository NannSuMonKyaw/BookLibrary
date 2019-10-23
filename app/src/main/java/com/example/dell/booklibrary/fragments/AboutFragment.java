package com.example.dell.booklibrary.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.booklibrary.DB.InitializeDatabase;
import com.example.dell.booklibrary.R;


public class AboutFragment extends Fragment {

 TextView textView;



    public AboutFragment() {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String userName;
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        textView=(TextView)v.findViewById(R.id.about_tv);
        final InitializeDatabase dbHelper = InitializeDatabase.getInstance(getContext());
        userName=dbHelper.getUserDAO().getUserName();
        textView.setText(userName);

        // Inflate the layout for this fragment
        return v;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}