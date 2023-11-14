package com.example.antoniabuzovprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     EditText usernameEditText;
     EditText passwordEditText;
     Button loginButton;
     TextView resultTextView;

      final String VALID_USERNAME = "abuzov";
      final String VALID_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        resultTextView = findViewById(R.id.resultTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredUsername.equals(VALID_USERNAME) && enteredPassword.equals(VALID_PASSWORD)) {
                    Intent intent = new Intent(MainActivity.this, Pocetna.class);
                    startActivity(intent);
                } else if (!enteredUsername.equals(VALID_USERNAME)) {
                    resultTextView.setText("Unijeli ste korisničko ime krivo.");
                } else if (!enteredPassword.equals(VALID_PASSWORD)) {
                    resultTextView.setText("Unijeli ste krivu lozinku.");
                } else resultTextView.setText("Unijeli ste krivu lozinku i korisničko ime");
            }
        });
    }
}
