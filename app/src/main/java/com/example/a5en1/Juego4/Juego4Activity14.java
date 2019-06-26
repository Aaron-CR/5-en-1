package com.example.a5en1.Juego4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a5en1.R;

public class Juego4Activity14 extends AppCompatActivity {

    private TextView contadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_4_14);

        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);
        contadores = (TextView) findViewById(R.id.txt_cont13);
        contadores.setText("Plata: " + plata + "\nHambre: " + hambre + "\nDiversión: " + diversion + "\nSocial: " + social + "\nFacultad: " + facultad + "\nSueño: " + sueño + "\nSalud: " + salud + "\nTiempo: " + tiempo);

    }

    public void muerta(View view) {
        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);


        Intent i = new Intent(this, Juego4Activity15.class);
        i.putExtra("plata", plata);
        i.putExtra("hambre", hambre);
        i.putExtra("diversion", diversion);
        i.putExtra("social", social);
        i.putExtra("facultad", facultad);
        i.putExtra("sueño", sueño);
        i.putExtra("salud", salud);
        i.putExtra("tiempo", tiempo);
        startActivity(i);

    }
}
