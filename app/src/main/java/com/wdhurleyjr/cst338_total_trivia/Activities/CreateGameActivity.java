package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wdhurleyjr.cst338_total_trivia.R;

public class CreateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        Intent intent = getIntent();
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);
        ImageView leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                landingPageIntent.putExtra("isAdmin", isAdmin);
                startActivity(landingPageIntent);
            }
        });
    }
    public static Intent createGameIntentFactory(Context context) {
        return new Intent(context, CreateGameActivity.class);
    }
}