package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDao {
    @Insert
    void insert(Game... games);

    @Update
    void  update(Game... games);

    @Delete
    void delete(Game... games);

    @Query("SELECT * FROM game_table WHERE gameId = :gameId")
    Game getGameById(String gameId);

    @Query("SELECT * FROM game_table")
    List<Game> getAllGames();
}
