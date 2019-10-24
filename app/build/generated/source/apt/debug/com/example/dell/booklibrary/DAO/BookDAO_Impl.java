package com.example.dell.booklibrary.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.dell.booklibrary.model.Book;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookDAO_Impl implements BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Book> __insertionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter<Book> __deletionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter<Book> __updateAdapterOfBook;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBookByName;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `book` (`bookName`,`authorName`,`price`,`releaseDate`,`category`,`summary`,`photoPath`) VALUES (?,?,?,?,?,?,?)";
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
        return "UPDATE OR ABORT `book` SET `bookName` = ?,`authorName` = ?,`price` = ?,`releaseDate` = ?,`category` = ?,`summary` = ?,`photoPath` = ? WHERE `bookName` = ?";
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
        if (value.getBookName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBookName());
        }
      }
    };
    this.__preparedStmtOfUpdateBookByName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update Book set authorName=?,price=?,releaseDate=?,category=?,summary=?,photoPath=? where bookName=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Book book) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final Book... books) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Book book) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Book book) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBookByName(final String bookName, final String authorName, final String price,
      final String releaseDate, final String category, final String summary,
      final String photoPath) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBookByName.acquire();
    int _argIndex = 1;
    if (authorName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, authorName);
    }
    _argIndex = 2;
    if (price == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, price);
    }
    _argIndex = 3;
    if (releaseDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, releaseDate);
    }
    _argIndex = 4;
    if (category == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, category);
    }
    _argIndex = 5;
    if (summary == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, summary);
    }
    _argIndex = 6;
    if (photoPath == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photoPath);
    }
    _argIndex = 7;
    if (bookName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, bookName);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBookByName.release(_stmt);
    }
  }

  @Override
  public List<Book> getAllBook() {
    final String _sql = "SELECT * FROM Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
      final int _cursorIndexOfCategoary = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoPath");
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
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Book getBookByName(final String bookName) {
    final String _sql = "SELECT * FROM Book Where bookName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bookName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bookName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
      final int _cursorIndexOfCategoary = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoPath");
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
        _result = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
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
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
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
  public String getphotoPathbyBookName(final String bookName) {
    final String _sql = "select photoPath from Book where bookName=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bookName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bookName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
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
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
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
  public List<Book> getBooksByCategory(final String category) {
    final String _sql = "SELECT * FROM Book WHERE category=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
      final int _cursorIndexOfCategoary = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
      final int _cursorIndexOfPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoPath");
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
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
