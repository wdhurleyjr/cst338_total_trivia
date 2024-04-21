package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "question_table",
        foreignKeys = @ForeignKey(
                entity = Game.class,
                parentColumns = "gameId",
                childColumns = "gameId",
                onDelete = ForeignKey.CASCADE  // Cascading delete
        )
)
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int questionId;
    private String gameId;  // Foreign key linking to Game
    private String gameQuestion;
    private String gameAnswer1;
    private String gameAnswer2;
    private String gameAnswer3;
    private String gameAnswer4;

    public Question(int questionId, String gameId, String gameQuestion, String gameAnswer1, String gameAnswer2, String gameAnswer3, String gameAnswer4) {
        this.questionId = questionId;
        this.gameId = gameId;
        this.gameQuestion = gameQuestion;
        this.gameAnswer1 = gameAnswer1;
        this.gameAnswer2 = gameAnswer2;
        this.gameAnswer3 = gameAnswer3;
        this.gameAnswer4 = gameAnswer4;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameQuestion() {
        return gameQuestion;
    }

    public void setGameQuestion(String gameQuestion) {
        this.gameQuestion = gameQuestion;
    }

    public String getGameAnswer1() {
        return gameAnswer1;
    }

    public void setGameAnswer1(String gameAnswer1) {
        this.gameAnswer1 = gameAnswer1;
    }

    public String getGameAnswer2() {
        return gameAnswer2;
    }

    public void setGameAnswer2(String gameAnswer2) {
        this.gameAnswer2 = gameAnswer2;
    }

    public String getGameAnswer3() {
        return gameAnswer3;
    }

    public void setGameAnswer3(String gameAnswer3) {
        this.gameAnswer3 = gameAnswer3;
    }

    public String getGameAnswer4() {
        return gameAnswer4;
    }

    public void setGameAnswer4(String gameAnswer4) {
        this.gameAnswer4 = gameAnswer4;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", gameId='" + gameId + '\'' +
                ", gameQuestion='" + gameQuestion + '\'' +
                ", gameAnswer1='" + gameAnswer1 + '\'' +
                ", gameAnswer2='" + gameAnswer2 + '\'' +
                ", gameAnswer3='" + gameAnswer3 + '\'' +
                ", gameAnswer4='" + gameAnswer4 + '\'' +
                '}';
    }
}
