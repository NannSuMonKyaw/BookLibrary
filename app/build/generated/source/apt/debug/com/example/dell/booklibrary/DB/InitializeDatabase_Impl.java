package com.example.dell.booklibrary.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.example.dell.booklibrary.DAO.BookDAO;
import com.example.dell.booklibrary.DAO.BookDAO_Impl;
import com.example.dell.booklibrary.DAO.UserDAO;
import com.example.dell.booklibrary.DAO.UserDAO_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class InitializeDatabase_Impl extends InitializeDatabase {
  private volatile BookDAO _bookDAO;

  private volatile UserDAO _userDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `book` (`bookName` TEXT NOT NULL, `authorName` TEXT, `price` TEXT, `releaseDate` TEXT, `category` TEXT, `summary` TEXT, `photoPath` TEXT, `isRead` TEXT, PRIMARY KEY(`bookName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`userName` TEXT NOT NULL, `password` TEXT, `email` TEXT, `phoneNo` TEXT, `address` TEXT, `photoPath` TEXT, PRIMARY KEY(`userName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b9b08b2b8c4bee3fd99835dc49c2c311\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `book`");
        _db.execSQL("DROP TABLE IF EXISTS `user`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBook = new HashMap<String, TableInfo.Column>(8);
        _columnsBook.put("bookName", new TableInfo.Column("bookName", "TEXT", true, 1));
        _columnsBook.put("authorName", new TableInfo.Column("authorName", "TEXT", false, 0));
        _columnsBook.put("price", new TableInfo.Column("price", "TEXT", false, 0));
        _columnsBook.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0));
        _columnsBook.put("category", new TableInfo.Column("category", "TEXT", false, 0));
        _columnsBook.put("summary", new TableInfo.Column("summary", "TEXT", false, 0));
        _columnsBook.put("photoPath", new TableInfo.Column("photoPath", "TEXT", false, 0));
        _columnsBook.put("isRead", new TableInfo.Column("isRead", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBook = new TableInfo("book", _columnsBook, _foreignKeysBook, _indicesBook);
        final TableInfo _existingBook = TableInfo.read(_db, "book");
        if (! _infoBook.equals(_existingBook)) {
          throw new IllegalStateException("Migration didn't properly handle book(com.example.dell.booklibrary.model.Book).\n"
                  + " Expected:\n" + _infoBook + "\n"
                  + " Found:\n" + _existingBook);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(6);
        _columnsUser.put("userName", new TableInfo.Column("userName", "TEXT", true, 1));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsUser.put("phoneNo", new TableInfo.Column("phoneNo", "TEXT", false, 0));
        _columnsUser.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        _columnsUser.put("photoPath", new TableInfo.Column("photoPath", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          throw new IllegalStateException("Migration didn't properly handle user(com.example.dell.booklibrary.model.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
      }
    }, "b9b08b2b8c4bee3fd99835dc49c2c311", "e83f9e862de6b76d181bec6e3b315b72");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "book","user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `book`");
      _db.execSQL("DELETE FROM `user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BookDAO getBookDAO() {
    if (_bookDAO != null) {
      return _bookDAO;
    } else {
      synchronized(this) {
        if(_bookDAO == null) {
          _bookDAO = new BookDAO_Impl(this);
        }
        return _bookDAO;
      }
    }
  }

  @Override
  public UserDAO getUserDAO() {
    if (_userDAO != null) {
      return _userDAO;
    } else {
      synchronized(this) {
        if(_userDAO == null) {
          _userDAO = new UserDAO_Impl(this);
        }
        return _userDAO;
      }
    }
  }
}
