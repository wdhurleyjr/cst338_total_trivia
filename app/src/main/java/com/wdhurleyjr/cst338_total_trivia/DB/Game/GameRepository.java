package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class GameRepository {

    private GameDao mGameDao;
    private LiveData<List<Game>> mAllGames;

    public GameRepository(Application application) {
        GameDataBase db = GameDataBase.getInstance(application);
        mGameDao = db.GameDao();
        mAllGames = mGameDao.getAllGames();
    }

    // Getter for all games
    public LiveData<List<Game>> getAllGames() {
        return mAllGames;
    }

    // Insert method
    public void insert(Game game) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mGameDao.insert(game);
        });
    }

    // Update method
    public void update(Game game) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mGameDao.update(game);
        });
    }

    // Delete method
    public void delete(Game game) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mGameDao.delete(game);
        });
    }
    // Other methods for specific queries or operations can be added as needed
}
