package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.Game;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDao;
import com.wdhurleyjr.cst338_total_trivia.DB.Game.GameDataBase;
import com.wdhurleyjr.cst338_total_trivia.R;

import java.util.List;

public class GameActivity extends AppCompatActivity {

    GameDao gameDao;

    Button triviaButton1;
    Button triviaButton2;
    Button triviaButton3;
    Button triviaButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);




        gameDao = GameDataBase.getInstance(this).GameDao();

        triviaButton1 = findViewById(R.id.trivia_button_1);
        triviaButton2 = findViewById(R.id.trivia_button_2);
//        triviaButton3 = findViewById(R.id.trivia_button_3);
//        triviaButton4 = findViewById(R.id.trivia_button_4);

        Intent intent = getIntent();
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);
        ImageView leftIcon = findViewById(R.id.left_icon);

        performButtonTextUpdate();

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                landingPageIntent.putExtra("isAdmin", isAdmin);
                startActivity(landingPageIntent);
            }
        });

        triviaButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGame = triviaButton1.getText().toString();
                Intent intent = new Intent(GameActivity.this, TriviaGameActivity.class);
                intent.putExtra("Harry Potter Trivia", selectedGame);
                startActivity(intent);
            }
        });

        triviaButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGame = triviaButton2.getText().toString();
                Intent intent2 = new Intent(GameActivity.this, TriviaGameActivity.class);
                intent2.putExtra("Star Wars Trivia", selectedGame);
                startActivity(intent2);
            }
        });
    }
    private void performButtonTextUpdate() {
        LiveData<List<Game>> gamesLiveData = gameDao.getAllGames();
        gamesLiveData.observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                if (games != null && games.size() >= 2) {
                    triviaButton1.setText(games.get(0).getGameName());
                    triviaButton2.setText(games.get(1).getGameName());
                    // Similarly, update other buttons if needed
                }
            }
        });
    }



//    private void performButtonTextUpdate() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                List<Game> games = gameDao.getAllGames();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (games != null) {
//                            triviaButton1.setText(games.get(0).getGameName());
//                            triviaButton2.setText(games.get(1).getGameName());
////                            triviaButton3.setText(games.get(2).getGameName());
////                            triviaButton4.setText(games.get(3).getGameName());
//                        }
//                    }
//                });
//            }
//        }).start();
//    }

    public static Intent gameIntentFactory(Context context) {
        return new Intent(context, GameActivity.class);
    }



}