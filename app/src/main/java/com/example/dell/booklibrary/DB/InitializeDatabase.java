package com.example.dell.booklibrary.DB;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.annotation.NonNull;


import com.example.dell.booklibrary.DAO.BookDAO;
import com.example.dell.booklibrary.DAO.UserDAO;
import com.example.dell.booklibrary.model.Book;
import com.example.dell.booklibrary.model.User;

@Database(entities = {Book.class,User.class}, version = 1,exportSchema = false)
public abstract class InitializeDatabase extends RoomDatabase {
    private static InitializeDatabase INSTANCE;

    public abstract BookDAO getBookDAO();
    public abstract UserDAO getUserDAO();


    public static InitializeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static InitializeDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                InitializeDatabase.class,
                "my-database")
                .allowMainThreadQueries()
                .build();
    }
}
