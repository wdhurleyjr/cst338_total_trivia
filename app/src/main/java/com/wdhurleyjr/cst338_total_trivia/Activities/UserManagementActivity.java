package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wdhurleyjr.cst338_total_trivia.R;

public class UserManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);

        Intent intent = getIntent();
        boolean isAdmin = intent.getBooleanExtra("isAdmin", false);
        ImageView leftIcon = findViewById(R.id.left_icon);
        Button giveAdminButton = findViewById(R.id.give_admin_button);
        Button deleteUserButton = findViewById(R.id.delete_user_button);
        Button addUserButton = findViewById(R.id.add_user_button);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landingPageIntent = LandingPageActivity.landingPageIntentFactory(getApplicationContext());
                landingPageIntent.putExtra("isAdmin", isAdmin);
                startActivity(landingPageIntent);
            }
        });
        giveAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giveAdminIntent = GiveAdminActivity.giveAdminIntentFactory(getApplicationContext());
                giveAdminIntent.putExtra("isAdmin", isAdmin);
                startActivity(giveAdminIntent);
            }
        });
        deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteUserIntent = DeleteUserActivity.deleteUserIntentFactory(getApplicationContext());
                deleteUserIntent.putExtra("isAdmin", isAdmin);
                startActivity(deleteUserIntent);
            }
        });
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addUserIntent = AddUserActivity.addUserIntentFactory(getApplicationContext());
                addUserIntent.putExtra("isAdmin", isAdmin);
                startActivity(addUserIntent);
            }
        });
    }
    public static Intent userManagementIntentFactory(Context context) {
        return new Intent(context, UserManagementActivity.class);
    }
}