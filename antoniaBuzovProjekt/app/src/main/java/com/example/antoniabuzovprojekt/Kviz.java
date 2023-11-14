package com.example.antoniabuzovprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Kviz extends AppCompatActivity {

     CheckBox option1, option2, option3, option4;
     RadioGroup question2Options, question3Options, question4Options, question5Options;
     Button checkButton;
    Button natrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kviz);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        question2Options = findViewById(R.id.question2Options);
        question3Options = findViewById(R.id.question3Options);
        question4Options = findViewById(R.id.question4Options);
        question5Options = findViewById(R.id.question5Options);
        checkButton = findViewById(R.id.checkButton);
        natrag = findViewById(R.id.backButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });

        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });
    }

    private void natrag(){
        Intent intent = new Intent(Kviz.this, Pocetna.class);
        startActivity(intent);
    }
    private void checkAnswers() {
        int score = 0;


        if (option1.isChecked() && !option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
            score++;
        }


        int selectedRadioButtonId2 = question2Options.getCheckedRadioButtonId();
        RadioButton selectedRadioButton2 = findViewById(selectedRadioButtonId2);
        if (selectedRadioButton2 != null && selectedRadioButton2.getText().equals("Hey Jude")) {
            score++;
        }

        int selectedRadioButtonId3 = question3Options.getCheckedRadioButtonId();
        RadioButton selectedRadioButton3 = findViewById(selectedRadioButtonId3);
        if (selectedRadioButton3 != null && selectedRadioButton3.getText().equals("Paul McCartney")) {
            score++;
        }


        int selectedRadioButtonId4 = question4Options.getCheckedRadioButtonId();
        RadioButton selectedRadioButton4 = findViewById(selectedRadioButtonId4);
        if (selectedRadioButton4 != null && selectedRadioButton4.getText().equals("I Want to Hold Your Hand")) {
            score++;
        }


        int selectedRadioButtonId5 = question5Options.getCheckedRadioButtonId();
        RadioButton selectedRadioButton5 = findViewById(selectedRadioButtonId5);
        if (selectedRadioButton5 != null && selectedRadioButton5.getText().equals("Golden Slumbers/Carry That Weight/The End")) {
            score++;
        }


        String resultMessage = "Broj točnih odgovora: " + score;
        Toast.makeText(this, resultMessage, Toast.LENGTH_SHORT).show();
    }
}
