package com.example.dell.booklibrary.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dell.booklibrary.model.User;

import java.util.List;
@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    User getUser();
    @Query("SELECT * FROM User where userName=:userName")
    User getUserByName(String userName);

    @Query("SELECT * FROM User where userName=:userName and password=:password")
    User getUser(String userName,String password);


    @Query("SELECT userName FROM User")
    String getUserName();

    @Query("SELECT email FROM User")
    List<String> getemail();

    @Query("SELECT password FROM User")
    String getPassword();

    @Query("SELECT phoneNo FROM User")
    List<String> getPhoneNo();
    
    @Query("SELECT address FROM User")
    List<String> getAddress();
    @Query("SELECT photoPath FROM User")
    List<String> getPhotoPath();
    @Query("Select count(userName) from User")
    int  getNamecount();




    @Insert
    void insert(User user);

    @Query("Update User set email=:userEmail,phoneNo=:PhoneNo,address=:address,photoPath=:photoPath where userName=:userName")
    void updateUserName(String userName,String userEmail,String PhoneNo,String address,String photoPath);




    @Query("Update User set userName=:userName")
    void updateUser(String userName);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
