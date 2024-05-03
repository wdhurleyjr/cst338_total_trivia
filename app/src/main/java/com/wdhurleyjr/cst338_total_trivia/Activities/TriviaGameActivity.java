package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;


import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDataBase;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
import com.wdhurleyjr.cst338_total_trivia.R;

import kotlinx.coroutines.*;


import java.util.ArrayList;
import java.util.List;

public class TriviaGameActivity extends AppCompatActivity {

    private GameDataBase dataBase;
    private TriviaGame_RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_game);


        GameDataBase database = GameDataBase.getInstance(this);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("Harry Potter Trivia")){
            String selectedGame = intent.getStringExtra("Harry Potter Trivia");
            //implement the harryPotterQuestions array from GameDataBase
            loadQuestions(selectedGame,recyclerView);
        }
        if(intent != null && intent.hasExtra("Star Wars Trivia")){
            String selectedGame = intent.getStringExtra("Star Wars Trivia");
            //implement the starWarsQuestions array from GameDataBase
           loadQuestions(selectedGame, recyclerView);
        }

    }

    private void loadQuestions(String selectedGame, RecyclerView recyclerView){
        new Thread(() -> {
            List<Question> questions = dataBase.QuestionDao().getQuestionsByGame(selectedGame);
            runOnUiThread(() -> {
                TriviaGame_RecyclerViewAdapter adapter = new TriviaGame_RecyclerViewAdapter(this, questions);
                recyclerView.setAdapter(adapter);
            });
        }).start();
    }

}