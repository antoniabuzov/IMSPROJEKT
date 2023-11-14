package com.example.antoniabuzovprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pocetna extends AppCompatActivity {

    RadioGroup radiogrupa;
    RadioButton pogodiBroj;
    RadioButton brzaMatematika;
    RadioButton kviz;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pocetna);

        radiogrupa = findViewById(R.id.radiogrupa);
        pogodiBroj = findViewById(R.id.pogodiBroj);
        brzaMatematika = findViewById(R.id.brzaMatematika);
        btn = findViewById(R.id.nastavi);
        kviz = findViewById(R.id.kviz);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nastavi();
            }
        });
    }

    private void nastavi(){
        if(pogodiBroj.isChecked()){
            Intent intent = new Intent(Pocetna.this, pogodiBroj.class);
            startActivity(intent);
        }else if(brzaMatematika.isChecked()){
            Intent intent = new Intent(Pocetna.this, brzaMatematika.class);
            startActivity(intent);
        }else if(kviz.isChecked()){
            Intent intent = new Intent(Pocetna.this, Kviz.class);
            startActivity(intent);
        }

    }


}