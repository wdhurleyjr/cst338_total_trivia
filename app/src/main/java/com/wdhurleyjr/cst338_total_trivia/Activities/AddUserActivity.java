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

import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLog;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDao;
import com.wdhurleyjr.cst338_total_trivia.DB.User.UserLogDataBase;
import com.wdhurleyjr.cst338_total_trivia.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddUserActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button giveAdminButton;
    UserLogDao userLogDao;
    boolean isAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_admin);

        Intent intent = getIntent();
        isAdmin = intent.getBooleanExtra("isAdmin", false);

        usernameEditText = findViewById(R.id.usernameAdmin_edit_text);
        passwordEditText = findViewById(R.id.passwordAdmin_edit_text);
        giveAdminButton = findViewById(R.id.give_admin_button);
        ImageView leftIcon = findViewById(R.id.left_icon);

        userLogDao = UserLogDataBase.getInstance(this).UserLogDao();

        giveAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String enteredUsername = usernameEditText.getText().toString().trim();
                final String enteredPassword = passwordEditText.getText().toString().trim();

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                    // Using a default email
                    UserLog newUser = new UserLog(enteredUsername, enteredPassword, "default@example.com", false);
                    userLogDao.insert(newUser);

                    runOnUiThread(() -> {
                        Toast.makeText(AddUserActivity.this, "New user added successfully", Toast.LENGTH_SHORT).show();
                        Intent userManagementIntent = UserManagementActivity.userManagementIntentFactory(getApplicationContext());
                        userManagementIntent.putExtra("isAdmin", isAdmin);
                        startActivity(userManagementIntent);
                    });
                });
            }
        });

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userManagementIntent = UserManagementActivity.userManagementIntentFactory(getApplicationContext());
                userManagementIntent.putExtra("isAdmin", isAdmin);
                startActivity(userManagementIntent);
            }
        });
    }

    public static Intent addUserIntentFactory(Context context) {
        return new Intent(context, AddUserActivity.class);
    }
}

