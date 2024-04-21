package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class, Question.class}, version = 1)

public abstract class GameDataBase extends RoomDatabase {
    public static final String GAME_DATA_BASE_NAME = "Game.DB";
    public static final String GAME_TABLE = "game_table";

    private static volatile GameDataBase instance;
    private static final Object LOCK = new Object();
    public abstract GameDao GameDao();
    public abstract QuestionDao QuestionDao();
    public static GameDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    // Build the Room database instance
                    instance = Room.databaseBuilder(context.getApplicationContext(), GameDataBase.class, GAME_DATA_BASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
