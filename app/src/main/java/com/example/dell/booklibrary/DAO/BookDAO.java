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
    @Query("SELECT * FROM Book where userId=:userId")
    List<Book> getAllBookbyUserId(int userId);

//    @Query("SELECT * FROM Book Where isRead='true'")
//    List<Book> getAllReadBook();



    @Query("SELECT * FROM Book Where bookName=:bookName")
    Book getBookByName(String bookName);
    @Query("SELECT * FROM Book Where bookId=:bookId")
    Book getBookById(int bookId);

    @Query("SELECT bookName FROM Book")
    List<String> getBookName();


    @Query("select photoPath from Book where bookName=:bookName ")
    String getphotoPathbyBookName(String bookName);

    @Query("select photoPath from Book where bookId=:bookId ")
    String getphotoPathbyBookId(int bookId);

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

    @Query("Delete from Book where bookName=:bookName")
    void deleteByBookName(String bookName);
    @Query("Delete from Book where bookId=:bookId")
    void deleteByBookId(int bookId);


    @Update
    void update(Book book);

    @Query("Update Book set bookName=:bookName,authorName=:authorName,userId=:userId,price=:price,releaseDate=:releaseDate,category=:category,summary=:summary,photoPath=:photoPath where bookId=:bookId")
    void updateBookById(int bookId,String bookName,String authorName,int userId,String price,String releaseDate,String category,String summary,String photoPath);



}
