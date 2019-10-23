package com.example.dell.booklibrary.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


import com.example.dell.booklibrary.DAO.BookDAO;
import com.example.dell.booklibrary.DAO.UserDAO;
import com.example.dell.booklibrary.model.Book;
import com.example.dell.booklibrary.model.User;

import java.util.concurrent.Executors;

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

                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).getBookDAO().insertAll(Book.populateData());

                            }
                        });
                    }
                })
                .build();
    }
}
