package com.wdhurleyjr.cst338_total_trivia;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;

import com.wdhurleyjr.cst338_total_trivia.Activities.CreateAccountActivity;
import com.wdhurleyjr.cst338_total_trivia.Activities.GiveAdminActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.wdhurleyjr.cst338_total_trivia", appContext.getPackageName());
    }

    @Test
    public void testGiveAdminActivityEditTexts() {
        Intent intent = GiveAdminActivity.giveAdminIntentFactory(ApplicationProvider.getApplicationContext());
        try (ActivityScenario<GiveAdminActivity> scenario = ActivityScenario.launch(intent)) {
            scenario.onActivity(activity -> {
                EditText usernameEditText = activity.findViewById(R.id.usernameAdmin_edit_text);
                EditText passwordEditText = activity.findViewById(R.id.passwordAdmin_edit_text);

                activity.runOnUiThread(() -> {
                    usernameEditText.setText("admin");
                    passwordEditText.setText("1234");
                });

                assertEquals("admin", usernameEditText.getText().toString());
                assertEquals("1234", passwordEditText.getText().toString());
            });
        }
    }
    @Test
    public void testEditTexts() {
        // Launch the activity
        Context context = ApplicationProvider.getApplicationContext();
        try (ActivityScenario<CreateAccountActivity> scenario = ActivityScenario.launch(CreateAccountActivity.createAccountIntentFactory(context))) {
            scenario.onActivity(activity -> {
                // Access the EditText fields
                EditText usernameEditText = activity.findViewById(R.id.activity_create_account_username_edit_text);
                EditText passwordEditText = activity.findViewById(R.id.activity_create_account_password_edit_text);
                EditText emailEditText = activity.findViewById(R.id.activity_create_account_email_edit_text);

                // Set some text in the EditText fields
                activity.runOnUiThread(() -> {
                    usernameEditText.setText("testUser");
                    passwordEditText.setText("testPass");
                    emailEditText.setText("test@example.com");
                });

                // Assert that the text was set correctly
                assertEquals("testUser", usernameEditText.getText().toString());
                assertEquals("testPass", passwordEditText.getText().toString());
                assertEquals("test@example.com", emailEditText.getText().toString());
            });
        }
    }
}