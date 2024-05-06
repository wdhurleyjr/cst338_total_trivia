package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;


import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDataBase;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.QuestionDao;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.QuestionRepository;
import com.wdhurleyjr.cst338_total_trivia.R;
import com.wdhurleyjr.cst338_total_trivia.TriviaViewModel.TriviaGameAdapter;
import com.wdhurleyjr.cst338_total_trivia.TriviaViewModel.TriviaViewModel;

import java.util.List;


public class TriviaGameActivity extends AppCompatActivity {

    private TriviaViewModel triviaViewModel;

    private QuestionRepository repository;
    private TriviaGameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_game);

        Button submit_button = findViewById(R.id.bottom_button);

        triviaViewModel = new ViewModelProvider(this).get(TriviaViewModel.class);


        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TriviaGameAdapter(new TriviaGameAdapter.TriviaGameDiff());
        recyclerView.setAdapter(adapter);

        repository = QuestionRepository.getRepository(getApplication());


        //repository.getAllQuestions().observe(this, adapter::submitList);

        Intent intent = getIntent();
        String selectedGame;
        if(intent.hasExtra("Harry Potter Trivia")){
            selectedGame = "1";
        } else if (intent.hasExtra("Star Wars Trivia")){
            selectedGame = "2";
        } else {
            selectedGame = "0";
            //this was select the third game..
        }


        repository.getQuestionsByGame(selectedGame).observe(this, questions -> {
            Log.d("TriviaGameActivity", "Received questions for game: " + selectedGame);

            adapter.submitList(questions);
        });


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = ScoreTriviaGame.scoreTriviaGameIntentFactory(getApplicationContext());
                startActivity(scoreIntent);
            }
        });


//        Intent intent = getIntent();
//        if(intent != null && intent.hasExtra("Harry Potter Trivia")){
//            String selectedGame = intent.getStringExtra("1");
//            repository.getQuestionsByGame(selectedGame).observe(this, questions -> {
//                Log.d("TriviaGameActivity", "Received questions for game: " + selectedGame);
//
//                adapter.submitList(questions);
//            });
//            if(selectedGame != null){
//                loadQuestions(selectedGame);
//            }
//
//        }
//        if(intent != null && intent.hasExtra("Star Wars Trivia")){
//            String selectedGame = intent.getStringExtra("2");
//            if(selectedGame != null){
//                repository.getQuestionsByGame(selectedGame).observe(this, questions -> {
//                    Log.d("TriviaGameActivity", "Received questions for game: " + selectedGame);
//
//                    adapter.submitList(questions);
//                });
//                loadQuestions(selectedGame);
//            }
//        }
//
//
//
//    }
//
//    private void loadQuestions(String selectedGame){
//        GameDataBase database = GameDataBase.getInstance(this);
//        database.QuestionDao().getQuestionsByGame(selectedGame).observe(this, new Observer<List<Question>>() {
//            @Override
//            public void onChanged(List<Question> questions) {
//                adapter.submitList(questions);
//            }
//        });
//    }
    }

}