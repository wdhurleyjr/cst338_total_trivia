package com.wdhurleyjr.cst338_total_trivia.TriviaViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.QuestionRepository;

import java.util.List;

public class TriviaViewModel extends AndroidViewModel {
    private QuestionRepository questionRepository;  //final??
    private final LiveData<List<Question>> allQuestions;

    public TriviaViewModel (Application application){
        super(application);
        questionRepository = QuestionRepository.getRepository(application);
        allQuestions = questionRepository.getAllQuestions();
    }

    public LiveData<List<Question>> getAllQuestions(){
        return  allQuestions;
    }

    public void insert(Question question){
        questionRepository.insert(question);
    }
}
