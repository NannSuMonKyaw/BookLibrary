package com.example.dell.booklibrary.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dell.booklibrary.model.Book;

import java.util.List;

@Dao
public interface BookDAO {

    @Query("SELECT * FROM Book")
    List<Book> getAllBook();

//    @Query("SELECT * FROM Book Where isRead='true'")
//    List<Book> getAllReadBook();



    @Query("SELECT * FROM Book Where bookName=:bookName")
    Book getBookByName(String bookName);

    @Query("SELECT bookName FROM Book")
    List<String> getBookName();

//    @Query("select isRead from Book where bookName=:bookName ")
//    String getIsReadbyBookName(String bookName);

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

    @Query("Update Book set authorName=:authorName,price=:price,releaseDate=:releaseDate,category=:category,summary=:summary,photoPath=:photoPath where bookName=:bookName")
    void updateBookByName(String bookName,String authorName,String price,String releaseDate,String category,String summary,String photoPath);

//    @Query("Update Book set isRead=:isRead where bookName=:bookName")
//    void updateIsRead(String isRead,String bookName);


}
