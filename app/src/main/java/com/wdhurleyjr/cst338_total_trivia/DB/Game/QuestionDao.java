package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert
    void insert(Question... questions);

    @Update
    void  update(Question... questions);

    @Delete
    void delete(Question... questions);

    @Query("SELECT * FROM question_table WHERE gameId = :gameId")
    List<Question> getQuestionsByGameId(String gameId);

    @Query("SELECT * FROM question_table")
    List<Question> getAllQuestions();
}
