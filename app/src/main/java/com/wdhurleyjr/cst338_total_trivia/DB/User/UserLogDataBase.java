package com.wdhurleyjr.cst338_total_trivia.DB.User;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDao;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.QuestionDao;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

@Database(entities = {UserLog.class}, version = 1)

public abstract class UserLogDataBase extends RoomDatabase {
    public static final String USER_LOG_DATA_BASE_NAME = "UserLog.DB";
    public static final String USER_LOG_TABLE = "user_log";
    private static volatile UserLogDataBase instance;
    private static final Object LOCK = new Object();
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);
    public abstract UserLogDao UserLogDao();

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                UserLogDao userLogDao = instance.UserLogDao();

                // Insert default admin user
                UserLog admin = new UserLog("admin1", "admin1", "admin@example.com", true);
                userLogDao.insert(admin);

                // Insert a test standard user
                UserLog user = new UserLog("user", "user", "testuser1@example.com", false);
                userLogDao.insert(user);
            });
        }
    };

    public static UserLogDataBase getInstance(Context context) {
        if(instance == null) {
            synchronized(LOCK) {
                if(instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), UserLogDataBase.class, USER_LOG_DATA_BASE_NAME)
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return instance;
    }
}
