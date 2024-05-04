package com.wdhurleyjr.cst338_total_trivia.DB.Game;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepository {

    private static QuestionRepository instance;
    private QuestionDao mQuestionDao;
    private LiveData<List<Question>> mAllQuestions;

    public QuestionRepository(Application application) {
        // Initialize the database and DAO
        GameDataBase db = GameDataBase.getInstance(application);
        mQuestionDao = db.QuestionDao();

        // Initialize LiveData by querying the DAO
        mAllQuestions = mQuestionDao.getAllQuestions();
    }

    public static  synchronized  QuestionRepository getRepository(Application application){
        if(instance == null){
            instance = new QuestionRepository(application);
        }
        return instance;
    }
    public LiveData<List<Question>> getAllQuestions() {
        return mAllQuestions;
    }

    public LiveData<List<Question>> getQuestionsByGame(String selectedGameName) {return mQuestionDao.getQuestionsByGame(selectedGameName); }

    // Method to insert a question
    public void insert(Question question) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mQuestionDao.insert(question);
        });
    }

    // Method to update a question
    public void update(Question question) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mQuestionDao.update(question);
        });
    }

    // Method to delete a question
    public void delete(Question question) {
        GameDataBase.databaseWriteExecutor.execute(() -> {
            mQuestionDao.delete(question);
        });
    }
}
