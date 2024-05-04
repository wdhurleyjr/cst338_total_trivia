package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;


import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDataBase;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.Question;
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

        triviaViewModel = new ViewModelProvider(this).get(TriviaViewModel.class);


        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TriviaGameAdapter(new TriviaGameAdapter.TriviaGameDiff());
        recyclerView.setAdapter(adapter);

        repository = QuestionRepository.getRepository(getApplication());

        //repository.getAllQuestions().observe(this, adapter::submitList);



        repository.getQuestionsByGame("1").observe(this, adapter::submitList);



        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("Harry Potter Trivia")){
            String selectedGame = intent.getStringExtra("1");
            if(selectedGame != null){
                loadQuestions(selectedGame);
            }

        }
        if(intent != null && intent.hasExtra("Star Wars Trivia")){
            String selectedGame = intent.getStringExtra("2");
            if(selectedGame != null){
                loadQuestions(selectedGame);
            }
        }



    }

    private void loadQuestions(String selectedGame){
        GameDataBase database = GameDataBase.getInstance(this);
        database.QuestionDao().getQuestionsByGame(selectedGame).observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                adapter.submitList(questions);
            }
        });
    }

}