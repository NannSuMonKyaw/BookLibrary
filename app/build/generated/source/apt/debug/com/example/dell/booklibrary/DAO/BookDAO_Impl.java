package com.example.dell.booklibrary.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.dell.booklibrary.model.Book;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BookDAO_Impl implements BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBook;

  private final SharedSQLiteStatement __preparedStmtOfUpdateIsRead;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `book`(`bookName`,`authorName`,`price`,`releaseDate`,`category`,`summary`,`photoPath`,`isRead`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getBookName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBookName());
        }
        if (value.getAuthorName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthorName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPrice());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReleaseDate());
        }
        if (value.getCategoary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCategoary());
        }
        if (value.getSummary() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSummary());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhotoPath());
        }
        if (value.getIsRead() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIsRead());
        }
      }
    };
    this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `book` WHERE `bookName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getBookName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBookName());
        }
      }
    };
    this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `book` SET `bookName` = ?,`authorName` = ?,`price` = ?,`releaseDate` = ?,`category` = ?,`summary` = ?,`photoPath` = ?,`isRead` = ? WHERE `bookName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getBookName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBookName());
        }
        if (value.getAuthorName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthorName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPrice());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReleaseDate());
        }
        if (value.getCategoary() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCategoary());
        }
        if (value.getSummary() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSummary());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhotoPath());
        }
        if (value.getIsRead() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIsRead());
        }
        if (value.getBookName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBookName());
        }
      }
    };
    this.__preparedStmtOfUpdateIsRead = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update Book set isRead=? where bookName=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(Book book) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(Book... books) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Book book) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Book book) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateIsRead(String isRead, String bookName) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateIsRead.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (isRead == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, isRead);
      }
      _argIndex = 2;
      if (bookName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, bookName);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateIsRead.release(_stmt);
    }
  }

  @Override
  public List<Book> getAllBook() {
    final String _sql = "SELECT * FROM Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookName = _cursor.getColumnIndexOrThrow("bookName");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("authorName");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final int _cursorIndexOfCategoary = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfSummary = _cursor.getColumnIndexOrThrow("summary");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final int _cursorIndexOfIsRead = _cursor.getColumnIndexOrThrow("isRead");
      final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Book _item;
        final String _tmpBookName;
        _tmpBookName = _cursor.getString(_cursorIndexOfBookName);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        final String _tmpPrice;
        _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final String _tmpCategoary;
        _tmpCategoary = _cursor.getString(_cursorIndexOfCategoary);
        final String _tmpSummary;
        _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        final String _tmpIsRead;
        _tmpIsRead = _cursor.getString(_cursorIndexOfIsRead);
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath,_tmpIsRead);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Book> getAllReadBook() {
    final String _sql = "SELECT * FROM Book Where isRead='true'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookName = _cursor.getColumnIndexOrThrow("bookName");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("authorName");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final int _cursorIndexOfCategoary = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfSummary = _cursor.getColumnIndexOrThrow("summary");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final int _cursorIndexOfIsRead = _cursor.getColumnIndexOrThrow("isRead");
      final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Book _item;
        final String _tmpBookName;
        _tmpBookName = _cursor.getString(_cursorIndexOfBookName);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        final String _tmpPrice;
        _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final String _tmpCategoary;
        _tmpCategoary = _cursor.getString(_cursorIndexOfCategoary);
        final String _tmpSummary;
        _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        final String _tmpIsRead;
        _tmpIsRead = _cursor.getString(_cursorIndexOfIsRead);
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath,_tmpIsRead);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Book getBookByName(String bookName) {
    final String _sql = "SELECT * FROM Book Where bookName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bookName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bookName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookName = _cursor.getColumnIndexOrThrow("bookName");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("authorName");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final int _cursorIndexOfCategoary = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfSummary = _cursor.getColumnIndexOrThrow("summary");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final int _cursorIndexOfIsRead = _cursor.getColumnIndexOrThrow("isRead");
      final Book _result;
      if(_cursor.moveToFirst()) {
        final String _tmpBookName;
        _tmpBookName = _cursor.getString(_cursorIndexOfBookName);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        final String _tmpPrice;
        _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final String _tmpCategoary;
        _tmpCategoary = _cursor.getString(_cursorIndexOfCategoary);
        final String _tmpSummary;
        _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        final String _tmpIsRead;
        _tmpIsRead = _cursor.getString(_cursorIndexOfIsRead);
        _result = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath,_tmpIsRead);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getBookName() {
    final String _sql = "SELECT bookName FROM Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getIsReadbyBookName(String bookName) {
    final String _sql = "select isRead from Book where bookName=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bookName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bookName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getphotoPathbyBookName(String bookName) {
    final String _sql = "select photoPath from Book where bookName=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bookName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bookName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getAuthorName() {
    final String _sql = "SELECT authorName FROM Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Book> getBooksByCategory(String category) {
    final String _sql = "SELECT * FROM Book WHERE category=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfBookName = _cursor.getColumnIndexOrThrow("bookName");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("authorName");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("releaseDate");
      final int _cursorIndexOfCategoary = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfSummary = _cursor.getColumnIndexOrThrow("summary");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final int _cursorIndexOfIsRead = _cursor.getColumnIndexOrThrow("isRead");
      final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Book _item;
        final String _tmpBookName;
        _tmpBookName = _cursor.getString(_cursorIndexOfBookName);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        final String _tmpPrice;
        _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        final String _tmpReleaseDate;
        _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
        final String _tmpCategoary;
        _tmpCategoary = _cursor.getString(_cursorIndexOfCategoary);
        final String _tmpSummary;
        _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        final String _tmpIsRead;
        _tmpIsRead = _cursor.getString(_cursorIndexOfIsRead);
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath,_tmpIsRead);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
