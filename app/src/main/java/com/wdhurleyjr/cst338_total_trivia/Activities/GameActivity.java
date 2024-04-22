package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wdhurleyjr.cst338_total_trivia.R;

import java.util.Objects;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                startActivity(landingPageIntent);
            }
        });
    }
    public static Intent gameIntentFactory(Context context) {
        return new Intent(context, GameActivity.class);
    }
}