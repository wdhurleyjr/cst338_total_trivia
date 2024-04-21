package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDataBase;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDao;
import com.wdhurleyjr.cst338_total_trivia.R;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLog;

public class CreateAccountActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText email;
    UserLogDao userLogDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        username = findViewById(R.id.activity_create_account_username_edit_text);
        password = findViewById(R.id.activity_create_account_password_edit_text);
        email = findViewById(R.id.activity_create_account_email_edit_text);
        Button create_account_button = findViewById(R.id.activity_create_account_button);

        userLogDao = Room.databaseBuilder(this, UserLogDataBase.class, UserLogDataBase.USER_LOG_DATA_BASE_NAME).allowMainThreadQueries().build().UserLogDao();

        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCreateAccount();
            }
        });
    }
    private void performCreateAccount() {
        String userUsername = username.getText().toString();
        String userPassword = password.getText().toString();
        String userEmail = email.getText().toString();

        if (userUsername.isEmpty() || userPassword.isEmpty() || userEmail.isEmpty()) {
            runOnUiThread(() -> Toast.makeText(CreateAccountActivity.this, "Please fill in all fields.", Toast.LENGTH_LONG).show());
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserLog newUser = new UserLog(userUsername, userPassword, userEmail, false);
                userLogDao.insert(newUser);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CreateAccountActivity.this, "Account created successfully.", Toast.LENGTH_LONG).show();
                        Intent loginIntent = LoginActivity.loginIntentFactory(CreateAccountActivity.this);
                        startActivity(loginIntent);
                    }
                });
            }
        }).start();
    }

    public static Intent createAccountIntentFactory(Context context) {
        return new Intent(context, CreateAccountActivity.class);
    }
}