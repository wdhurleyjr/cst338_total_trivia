package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wdhurleyjr.cst338_total_trivia.R;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Intent intent = getIntent();
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);
        Button adminButton1 = findViewById(R.id.activity_landing_page_create_game_button);
        Button adminButton2 = findViewById(R.id.activity_landing_page_user_management_button);
        Button logoutButton = findViewById(R.id.activity_landing_page_logout_button);
        Button playButton = findViewById(R.id.activity_landing_page_play_button);
        Button leaderboardButton = findViewById(R.id.activity_landing_page_leaderboard_button);


        // Set visibility based on the admin status
        if (isAdmin) {
            adminButton1.setVisibility(View.VISIBLE);  // Show the admin-only buttons
            adminButton2.setVisibility(View.VISIBLE);
        } else {
            adminButton1.setVisibility(View.GONE);  // Hide the admin-only buttons
            adminButton2.setVisibility(View.GONE);
        }
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = MainActivity.mainActivityIntentFactory(getApplicationContext());
                startActivity(mainActivityIntent);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = GameActivity.gameIntentFactory(getApplicationContext());
                gameActivityIntent.putExtra("isAdmin", isAdmin);
                startActivity(gameActivityIntent);
            }
        });
        adminButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createGameActivityIntent = CreateGameActivity.createGameIntentFactory(getApplicationContext());
                createGameActivityIntent.putExtra("isAdmin", isAdmin);
                startActivity(createGameActivityIntent);
            }
        });
        adminButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userManagemnetActivityIntent = UserManagementActivity.userManagementIntentFactory(getApplicationContext());
                userManagemnetActivityIntent.putExtra("isAdmin", isAdmin);
                startActivity(userManagemnetActivityIntent);
            }
        });
        leaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaderboardActivityIntent = LeaderboardActivity.leaderboardIntentFactory(getApplicationContext());
                leaderboardActivityIntent.putExtra("isAdmin", isAdmin);
                startActivity(leaderboardActivityIntent);
            }
        });
    }

    public static Intent landingPageIntentFactory(Context context) {
        return new Intent(context, LandingPageActivity.class);
    }
}