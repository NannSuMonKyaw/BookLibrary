package com.example.dell.booklibrary.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.dell.booklibrary.model.User;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class UserDAO_Impl implements UserDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUser;

  public UserDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user`(`userName`,`password`,`email`,`phoneNo`,`address`,`photoPath`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassword());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPhoneNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhoneNo());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddress());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhotoPath());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `userName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user` SET `userName` = ?,`password` = ?,`email` = ?,`phoneNo` = ?,`address` = ?,`photoPath` = ? WHERE `userName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassword());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPhoneNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhoneNo());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddress());
        }
        if (value.getPhotoPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhotoPath());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
      }
    };
    this.__preparedStmtOfUpdateUserName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update User set email=?,phoneNo=?,address=?,photoPath=? where userName=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUser = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update User set userName=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(User user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(User... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(User user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(User user) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUserName(String userName, String userEmail, String PhoneNo, String address,
      String photoPath) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserName.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (userEmail == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, userEmail);
      }
      _argIndex = 2;
      if (PhoneNo == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, PhoneNo);
      }
      _argIndex = 3;
      if (address == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, address);
      }
      _argIndex = 4;
      if (photoPath == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, photoPath);
      }
      _argIndex = 5;
      if (userName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, userName);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUserName.release(_stmt);
    }
  }

  @Override
  public void updateUser(String userName) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUser.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (userName == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, userName);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUser.release(_stmt);
    }
  }

  @Override
  public User getUser() {
    final String _sql = "SELECT * FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("userName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNo = _cursor.getColumnIndexOrThrow("phoneNo");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpPhoneNo;
        _tmpPhoneNo = _cursor.getString(_cursorIndexOfPhoneNo);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        _result = new User(_tmpUserName,_tmpPassword,_tmpEmail,_tmpPhoneNo,_tmpAddress,_tmpPhotoPath);
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
  public User getUserByName(String userName) {
    final String _sql = "SELECT * FROM User where userName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUserName = _cursor.getColumnIndexOrThrow("userName");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNo = _cursor.getColumnIndexOrThrow("phoneNo");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfPhotoPath = _cursor.getColumnIndexOrThrow("photoPath");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUserName;
        _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpPhoneNo;
        _tmpPhoneNo = _cursor.getString(_cursorIndexOfPhoneNo);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        final String _tmpPhotoPath;
        _tmpPhotoPath = _cursor.getString(_cursorIndexOfPhotoPath);
        _result = new User(_tmpUserName,_tmpPassword,_tmpEmail,_tmpPhoneNo,_tmpAddress,_tmpPhotoPath);
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
  public String getUser(String userName, String password) {
    final String _sql = "SELECT userName FROM User where userName=? and password=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
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
  public String getUserName() {
    final String _sql = "SELECT userName FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public List<String> getemail() {
    final String _sql = "SELECT email FROM User";
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
  public List<String> getPhoneNo() {
    final String _sql = "SELECT phoneNo FROM User";
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
  public List<String> getAddress() {
    final String _sql = "SELECT address FROM User";
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
  public List<String> getPhotoPath() {
    final String _sql = "SELECT photoPath FROM User";
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
}
