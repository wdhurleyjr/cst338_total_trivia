package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wdhurleyjr.cst338_total_trivia.R;

public class ScoreTriviaGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_trivia_game);
    }

    public static Intent scoreTriviaGameIntentFactory(Context context){
        return new Intent(context, ScoreTriviaGame.class);
    }
}