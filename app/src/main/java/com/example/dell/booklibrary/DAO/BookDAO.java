package com.example.dell.booklibrary.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.dell.booklibrary.model.Book;

import java.util.List;

@Dao
public interface BookDAO {

    @Query("SELECT * FROM Book")
    List<Book> getAllBook();

    @Query("SELECT * FROM Book Where isRead='true'")
    List<Book> getAllReadBook();



    @Query("SELECT * FROM Book Where bookName=:bookName")
    Book getBookByName(String bookName);

    @Query("SELECT bookName FROM Book")
    List<String> getBookName();

    @Query("select isRead from Book where bookName=:bookName ")
    String getIsReadbyBookName(String bookName);

    @Query("select photoPath from Book where bookName=:bookName ")
    String getphotoPathbyBookName(String bookName);

    @Query("SELECT authorName FROM Book")
    List<String> getAuthorName();

    @Query("SELECT * FROM Book WHERE category=:category")
    List<Book> getBooksByCategory(String category);




    @Insert
    void insert(Book book);

    @Insert
    void insertAll(Book... books);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);

    @Query("Update Book set isRead=:isRead where bookName=:bookName")
    void updateIsRead(String isRead,String bookName);


}
