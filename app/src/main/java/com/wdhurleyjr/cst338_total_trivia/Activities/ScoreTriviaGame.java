package com.wdhurleyjr.cst338_total_trivia.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLog;
import com.wdhurleyjr.cst338_total_trivia.R;
import com.wdhurleyjr.cst338_total_trivia.TriviaViewModel.TriviaGameAdapter;

public class ScoreTriviaGame extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_trivia_game);


        Button try_again = findViewById(R.id.try_again_button);
        Button return_to_main = findViewById(R.id.Return_to_main_menu_button);

        return_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                startActivity(landingPageIntent);
            }
        });
        try_again.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public static Intent scoreTriviaGameIntentFactory(Context context){
        return new Intent(context, ScoreTriviaGame.class);
    }
}