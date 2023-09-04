package com.matheas.doggy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.matheas.doggy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, DogsList.class);
        startActivity(intent);
    }
    public void navigateToForgotPasswordActivity(View view) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    public void login(View view) {
        EditText usernameEditTest=(EditText) findViewById(R.id.user_name_edit_text);
        EditText passwordEditText=(EditText) findViewById(R.id.password_edit_text);
        String username = usernameEditTest.getText().toString();
        String password = passwordEditText.getText().toString();

        if(username.equals("Matheas") && password.equals("password")) {
            Intent intent = new Intent(this, DogsList.class);
            startActivity(intent);
        }
        else {
            View rootView = findViewById(android.R.id.content);
            String message = "Invalid login credentials !!";
            Snackbar snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }
}