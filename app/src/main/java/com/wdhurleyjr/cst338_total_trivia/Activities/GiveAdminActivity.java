package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class GiveAdminActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button giveAdminButton;
    UserLogDao userLogDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_admin);

        Intent intent = getIntent();
        usernameEditText = findViewById(R.id.usernameAdmin_edit_text);
        passwordEditText = findViewById(R.id.passwordAdmin_edit_text);
        giveAdminButton = findViewById(R.id.give_admin_button);
        ImageView leftIcon = findViewById(R.id.left_icon);
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);

        userLogDao = UserLogDataBase.getInstance(this).UserLogDao();

        giveAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String enteredUsername = usernameEditText.getText().toString().trim();
                final String enteredPassword = passwordEditText.getText().toString().trim();

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                    UserLog user = userLogDao.getUserByUsernameAndPassword(enteredUsername, enteredPassword);
                    if (user != null) {
                        user.setAdmin(!user.getAdmin());
                        userLogDao.update(user); // This needs to be on background
                    }
                    runOnUiThread(() -> {
                        if (user != null) {
                            Toast.makeText(GiveAdminActivity.this, "Admin privileges updated successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GiveAdminActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                        }

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

    public static Intent giveAdminIntentFactory(Context context) {
        return new Intent(context, GiveAdminActivity.class);
    }
}
