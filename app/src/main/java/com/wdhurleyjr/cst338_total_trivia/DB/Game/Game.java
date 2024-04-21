package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "game_table")
public class Game {
    @NonNull
    @PrimaryKey
    private String gameId;
    private String gameName;

    public Game(String gameId, String gameName) {
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", gameName='" + gameName + '\'' +
                '}';
    }
}

