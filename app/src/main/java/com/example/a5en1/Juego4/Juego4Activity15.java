package com.example.a5en1.Juego4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a5en1.MainActivity;
import com.example.a5en1.R;

public class Juego4Activity15 extends AppCompatActivity {

    private TextView contadores;
    private TextView puntajeTotal;
    int puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_4_15);

        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);
        contadores = (TextView) findViewById(R.id.txt_cont15);
        contadores.setText("Plata: " + plata + "\nHambre: " + hambre + "\nDiversión: " + diversion + "\nSocial: " + social + "\nFacultad: " + facultad + "\nSueño: " + sueño + "\nSalud: " + salud + "\nTiempo: " + tiempo);

        puntaje= (plata+hambre+diversion+social+facultad+sueño+salud+tiempo)*10;
        puntajeTotal = (TextView) findViewById(R.id.txt_punt15);
        puntajeTotal.setText("PUNTAJE TOTAL: " + puntaje);

    }

    public void inicio(View view) {
        int plata = 5;
        int hambre = 5;
        int diversion = 5;
        int social = 5;
        int facultad = 5;
        int sueño = 5;
        int salud = 5;
        int tiempo = 5;
        int puntaje = getIntent().getIntExtra("puntaje", 400);

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("plata", plata);
        i.putExtra("hambre", hambre);
        i.putExtra("diversion", diversion);
        i.putExtra("social", social);
        i.putExtra("facultad", facultad);
        i.putExtra("sueño", sueño);
        i.putExtra("salud", salud);
        i.putExtra("tiempo", tiempo);
        i.putExtra("puntaje", puntaje);
        startActivity(i);

    }
}
