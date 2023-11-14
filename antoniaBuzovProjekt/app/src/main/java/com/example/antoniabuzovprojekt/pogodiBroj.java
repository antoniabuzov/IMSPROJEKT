package com.example.antoniabuzovprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class pogodiBroj extends AppCompatActivity {

    EditText unos;
    Button provjera;
    TextView rezultat;
    Random nasumicno;
    int pokusaji;
    Button natrag;
    int random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pogodi_broj);

        unos = findViewById(R.id.unos);
        provjera = findViewById(R.id.provjera);
        rezultat = findViewById(R.id.output);
        natrag = findViewById(R.id.natrag);

        nasumicno = new Random();
        random = nasumicno.nextInt(10);
        pokusaji = 0;


        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });

        provjera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjera();
            }
        });


    }

    private void natrag(){
        Intent intent = new Intent(pogodiBroj.this, Pocetna.class);
        startActivity(intent);
    }

    private void provjera(){
        String pogodakTxt = unos.getText().toString();
        if(!pogodakTxt.isEmpty()){
            int pogodak = Integer.parseInt((pogodakTxt));
            pokusaji ++;

            if(pogodak == random){
                String poruka = "Čestitke, pogodili ste broj u " + pokusaji + " pokušaja.";
                rezultat.setText(poruka);
            } else if(pogodak < random){
                rezultat.setText("Broj je premal");
            } else {
                rezultat.setText("Broj je prevelik");
            }
        }
    }


}