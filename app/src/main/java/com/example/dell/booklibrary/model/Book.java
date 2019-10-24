package com.example.dell.booklibrary.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Entity(tableName = "book")
public class Book implements Parcelable {

    public int getBookId() {
        return bookId;
    }

    public void setBookId( int bookId) {
        this.bookId = bookId;
    }


    @PrimaryKey(autoGenerate = true)
    private int bookId;
    @Nullable
    @ColumnInfo(name = "bookName")
    private String bookName;

    @Nullable
    @ColumnInfo(name = "authorName")
    private String authorName;

    @Nullable
    public int getUserId() {
        return userId;
    }

    public void setUserId(@Nullable int userId) {
        this.userId = userId;
    }

    @Nullable
    @ColumnInfo(name="userId")
    private int userId;

    @Nullable
    @ColumnInfo(name = "price")
    private String price;

    @Nullable
    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @Nullable
    @ColumnInfo(name = "category")
    private String categoary;

    @Nullable
    @ColumnInfo(name = "summary")
    private String summary;

    @Nullable
    @ColumnInfo(name = "photoPath")
    private String photoPath;






    protected Book(Parcel in) {

        bookName=in.readString();
        authorName=in.readString();
        userId=in.readInt();
        price=in.readString();
        releaseDate=in.readString();
        categoary=in.readString();
        summary=in.readString();
        photoPath=in.readString();


    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };






    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }



    public String getCategoary() {
        return categoary;
    }

    public void setCategoary(String categoary) {
        this.categoary = categoary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public String getPhotoPath() {
        return photoPath;
    }



    public Book(@Nullable String bookName,@Nullable String authorName,@Nullable int userId, @Nullable String price,@Nullable String releaseDate,@Nullable String categoary,@Nullable String summary,@Nullable String photoPath ) {

        this.bookName = bookName;
        this.authorName = authorName;
        this.userId=userId;
        this.price = price;
        this.releaseDate = releaseDate;
        this.categoary = categoary;
        this.summary = summary;
        this.photoPath=photoPath;


    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
