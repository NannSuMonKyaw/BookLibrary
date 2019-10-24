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

  private final SharedSQLiteStatement __preparedStmtOfDeleteByBookName;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByBookId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBookById;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `book` (`bookId`,`bookName`,`authorName`,`userId`,`price`,`releaseDate`,`category`,`summary`,`photoPath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getBookId());
        if (value.getBookName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBookName());
        }
        if (value.getAuthorName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthorName());
        }
        stmt.bindLong(4, value.getUserId());
        if (value.getPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrice());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDate());
        }
        if (value.getCategoary() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCategoary());
        }
        if (value.getSummary() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSummary());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPhotoPath());
        }
      }
    };
    this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `book` WHERE `bookId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getBookId());
      }
    };
    this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `book` SET `bookId` = ?,`bookName` = ?,`authorName` = ?,`userId` = ?,`price` = ?,`releaseDate` = ?,`category` = ?,`summary` = ?,`photoPath` = ? WHERE `bookId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getBookId());
        if (value.getBookName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBookName());
        }
        if (value.getAuthorName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthorName());
        }
        stmt.bindLong(4, value.getUserId());
        if (value.getPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrice());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReleaseDate());
        }
        if (value.getCategoary() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCategoary());
        }
        if (value.getSummary() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSummary());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPhotoPath());
        }
        stmt.bindLong(10, value.getBookId());
      }
    };
    this.__preparedStmtOfDeleteByBookName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Book where bookName=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByBookId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Book where bookId=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBookById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update Book set bookName=?,authorName=?,userId=?,price=?,releaseDate=?,category=?,summary=?,photoPath=? where bookId=?";
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
  public void deleteByBookName(final String bookName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByBookName.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfDeleteByBookName.release(_stmt);
    }
  }

  @Override
  public void deleteByBookId(final int bookId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByBookId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, bookId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByBookId.release(_stmt);
    }
  }

  @Override
  public void updateBookById(final int bookId, final String bookName, final String authorName,
      final int userId, final String price, final String releaseDate, final String category,
      final String summary, final String photoPath) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBookById.acquire();
    int _argIndex = 1;
    if (bookName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, bookName);
    }
    _argIndex = 2;
    if (authorName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, authorName);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 4;
    if (price == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, price);
    }
    _argIndex = 5;
    if (releaseDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, releaseDate);
    }
    _argIndex = 6;
    if (category == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, category);
    }
    _argIndex = 7;
    if (summary == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, summary);
    }
    _argIndex = 8;
    if (photoPath == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photoPath);
    }
    _argIndex = 9;
    _stmt.bindLong(_argIndex, bookId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBookById.release(_stmt);
    }
  }

  @Override
  public List<Book> getAllBook() {
    final String _sql = "SELECT * FROM Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
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
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
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
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpUserId,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        final int _tmpBookId;
        _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
        _item.setBookId(_tmpBookId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Book> getAllBookbyUserId(final int userId) {
    final String _sql = "SELECT * FROM Book where userId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
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
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
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
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpUserId,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        final int _tmpBookId;
        _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
        _item.setBookId(_tmpBookId);
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
      final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
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
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
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
        _result = new Book(_tmpBookName,_tmpAuthorName,_tmpUserId,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        final int _tmpBookId;
        _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
        _result.setBookId(_tmpBookId);
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
  public Book getBookById(final int bookId) {
    final String _sql = "SELECT * FROM Book Where bookId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
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
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
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
        _result = new Book(_tmpBookName,_tmpAuthorName,_tmpUserId,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        final int _tmpBookId;
        _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
        _result.setBookId(_tmpBookId);
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
  public String getphotoPathbyBookId(final int bookId) {
    final String _sql = "select photoPath from Book where bookId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
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
      final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
      final int _cursorIndexOfBookName = CursorUtil.getColumnIndexOrThrow(_cursor, "bookName");
      final int _cursorIndexOfAuthorName = CursorUtil.getColumnIndexOrThrow(_cursor, "authorName");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
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
        final int _tmpUserId;
        _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
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
        _item = new Book(_tmpBookName,_tmpAuthorName,_tmpUserId,_tmpPrice,_tmpReleaseDate,_tmpCategoary,_tmpSummary,_tmpPhotoPath);
        final int _tmpBookId;
        _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
        _item.setBookId(_tmpBookId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
