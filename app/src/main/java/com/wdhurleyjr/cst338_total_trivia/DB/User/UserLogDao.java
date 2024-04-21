package com.wdhurleyjr.cst338_total_trivia.DB.User;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserLogDao {
    @Insert
    void insert(UserLog... userLogs);

    @Update
    void  update(UserLog... userLogs);

    @Delete
    void delete(UserLog... userLogs);

    @Query("SELECT * FROM " + UserLogDataBase.USER_LOG_TABLE)
    List<UserLog> getUserLogs();
    @Query("SELECT * FROM " + UserLogDataBase.USER_LOG_TABLE + " WHERE username = :username")
    UserLog getUserByUsername(String username);
    @Query("SELECT * FROM " + UserLogDataBase.USER_LOG_TABLE + " WHERE password = :password")
    UserLog getUserByPassword(String password);
    @Query("SELECT * FROM " + UserLogDataBase.USER_LOG_TABLE + " WHERE username = :username AND password = :password")
    UserLog getUserByUsernameAndPassword(String username, String password);
    @Query("SELECT * FROM " + UserLogDataBase.USER_LOG_TABLE + " WHERE id = :userId")
    UserLog getUserById(int userId);
}
