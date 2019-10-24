package com.example.dell.booklibrary.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Entity(tableName = "user")
public class User {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userName")
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ColumnInfo(name="password")
    private String password;



    @ColumnInfo(name = "email")
    private String email;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    @Nullable
    @ColumnInfo(name = "phoneNo")
    private String phoneNo;

    public User( String userName ,String password,@Nullable String email,@Nullable String phoneNo,@Nullable String address,@Nullable String photoPath) {

        this.userName = userName;
        this.password=password;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.photoPath = photoPath;
    }

    @Nullable
    @ColumnInfo(name = "address")
    private String address;
    @Nullable
    @ColumnInfo(name = "photoPath")
    private String photoPath;


}
