package com.example.antoniabuzovprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class brzaMatematika extends AppCompatActivity {

    private TextView tekstPitanja;
    private EditText unosOdgovora;
    private Button potvrdiBtn;
    private TextView tekstTajmera;
    private TextView tekstNajboljegRezultata;
    private ImageView slika;

    private int rezultat = 0;
    private int najboljiRezultat = 0;
    private int preostaloSekundi = 10;
    private CountDownTimer tajmer;
    private int tocanOdgovor;
    private Button natrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brza_matematika);

        tekstPitanja = findViewById(R.id.pitanje);
        unosOdgovora = findViewById(R.id.odgovor);
        potvrdiBtn = findViewById(R.id.submit);
        tekstTajmera = findViewById(R.id.timer);
        tekstNajboljegRezultata = findViewById(R.id.hs);
        natrag = findViewById(R.id.natrag1);
        slika = findViewById(R.id.slika);

        slika.setVisibility(View.INVISIBLE);

        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocetniMeni();
            }

            private void pocetniMeni() {
                Intent intent = new Intent(brzaMatematika.this, Pocetna.class);
                startActivity(intent);
            }
        });

        potvrdiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriOdgovor();
            }
        });

        zapocniIgru();
    }

    private void zapocniIgru() {
        generirajPitanje();
        pokreniTajmer();
    }

    private void generirajPitanje() {
        int broj1 = (int) (Math.random() * 10) + 1;
        int broj2 = (int) (Math.random() * 10) + 1;
        int operator = (int) (Math.random() * 3);

        String pitanje = "";
        int rezultatOperacije = 0;

        switch (operator) {
            case 0:
                pitanje = broj1 + " + " + broj2;
                rezultatOperacije = broj1 + broj2;
                break;
            case 1:
                pitanje = broj1 + " - " + broj2;
                rezultatOperacije = broj1 - broj2;
                break;
            case 2:
                pitanje = broj1 + " * " + broj2;
                rezultatOperacije = broj1 * broj2;
                break;
        }

        tocanOdgovor = rezultatOperacije;
        tekstPitanja.setText(pitanje);
    }

    private void pokreniTajmer() {
        tajmer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                preostaloSekundi = (int) millisUntilFinished / 1000;
                tekstTajmera.setText("Preostalo vrijeme: " + preostaloSekundi + "s");
            }

            public void onFinish() {
                krajIgre();
            }
        }.start();
    }

    private void provjeriOdgovor() {
        try {
            double korisnickiOdgovor = Double.parseDouble(unosOdgovora.getText().toString());

            if (korisnickiOdgovor == tocanOdgovor) {
                rezultat += 10;
                azurirajRezultat();
                Toast.makeText(this, "Točno! +10 bodova", Toast.LENGTH_SHORT).show();
            } else {
                rezultat -= 5;
                azurirajRezultat();
                Toast.makeText(this, "Netočno! -5 bodova", Toast.LENGTH_SHORT).show();

            }


            generirajPitanje();
            unosOdgovora.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Morate unijeti broj", Toast.LENGTH_SHORT).show();
        }
    }

    private void azurirajRezultat() {
        if (rezultat > najboljiRezultat) {
            najboljiRezultat = rezultat;
            slika.setVisibility(View.VISIBLE);
        }

        tekstNajboljegRezultata.setText("Najbolji rezultat: " + najboljiRezultat);
    }

    private void krajIgre() {
        tajmer.cancel();
        Toast.makeText(this, "Vrijeme je isteklo! Kraj igre.", Toast.LENGTH_SHORT).show();
        rezultat = 0;
        azurirajRezultat();

        potvrdiBtn.setVisibility(View.INVISIBLE);
        tekstPitanja.setText("Kraj!");
    }
}
