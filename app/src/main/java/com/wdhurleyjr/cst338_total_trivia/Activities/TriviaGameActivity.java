package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import com.wdhurleyjr.cst338_total_trivia.R;

public class TriviaGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_game);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("Harry Potter Trivia")){
            String selectedGame = intent.getStringExtra("Harry Potter Trivia");
        }
        if(intent != null && intent.hasExtra("Star Wars Trivia")){
            String selectedGame = intent.getStringExtra("Star Wars Trivia");
        }

    }
}