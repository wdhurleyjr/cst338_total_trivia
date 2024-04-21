package com.wdhurleyjr.cst338_total_trivia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wdhurleyjr.cst338_total_trivia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sign_in_button = findViewById(R.id.sign_in_button);
        Button create_account_button = findViewById(R.id.create_account_button);

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = LoginActivity.loginIntentFactory(getApplicationContext());
                startActivity(loginIntent);
            }
        });
        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createAccountIntent = CreateAccountActivity.createAccountIntentFactory(getApplicationContext());
                startActivity(createAccountIntent);
            }
        });
    }
    public static Intent mainActivityIntentFactory(Context context) {
        return new Intent(context, MainActivity.class);
    }
}