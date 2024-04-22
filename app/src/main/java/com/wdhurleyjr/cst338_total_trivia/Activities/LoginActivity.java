package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDataBase;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDao;
import com.wdhurleyjr.cst338_total_trivia.R;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLog;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    UserLogDao userLogDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogDao = UserLogDataBase.getInstance(this).UserLogDao();

        username = findViewById(R.id.username_edit_text);
        password = findViewById(R.id.password_edit_text);
        Button log_in_button = findViewById(R.id.login_activity_log_in_button);
        ImageView leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = MainActivity.mainActivityIntentFactory(getApplicationContext());
                startActivity(mainActivityIntent);
            }
        });

        log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }
    private void performLogin() {
        String userUsername = username.getText().toString();
        String userPassword = password.getText().toString();

        // Run database interactions in the background
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserLog user = userLogDao.getUserByUsernameAndPassword(userUsername, userPassword);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null) {
                            Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                            landingPageIntent.putExtra("isAdmin", user.getAdmin());
                            startActivity(landingPageIntent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "User does not exist or incorrect password.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }).start();
    }
    public static Intent loginIntentFactory(Context context) {
        return new Intent(context, LoginActivity.class);
    }
}