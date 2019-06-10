package com.example.a5en1.Juego4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

public class Juego4Activity4_1_2 extends AppCompatActivity {

    private RadioButton rb1, rb2;
    private TextView contadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_4_4_1_2);

        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);
        rb1 = (RadioButton) findViewById(R.id.rb_4_1_2a);
        rb2 = (RadioButton) findViewById(R.id.rb_4_1_2b);
        contadores = (TextView) findViewById(R.id.txt_cont4_1_2);
        contadores.setText("Plata: " + plata + "\nHambre: " + hambre + "\nDiversión: " + diversion + "\nSocial: " + social + "\nFacultad: " + facultad + "\nSueño: " + sueño + "\nSalud: " + salud + "\nTiempo: " + tiempo);

    }

    public void siguiente(View view) {
        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);

        if (rb1.isChecked() == true) {
            diversion++; facultad--;
            Toast.makeText(this, "+diversión, -facultad", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Juego4Activity6.class);
            i.putExtra("plata", plata);
            i.putExtra("hambre", hambre);
            i.putExtra("diversion", diversion);
            i.putExtra("social", social);
            i.putExtra("facultad", facultad);
            i.putExtra("sueño", sueño);
            i.putExtra("salud", salud);
            i.putExtra("tiempo", tiempo);
            startActivity(i);
        } else if (rb2.isChecked() == true) {
            diversion--; facultad++; sueño--;
            Toast.makeText(this, "-diversión, +facultad, -sueño", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Juego4Activity6.class);
            i.putExtra("plata", plata);
            i.putExtra("hambre", hambre);
            i.putExtra("diversion", diversion);
            i.putExtra("social", social);
            i.putExtra("facultad", facultad);
            i.putExtra("sueño", sueño);
            i.putExtra("salud", salud);
            i.putExtra("tiempo", tiempo);
            startActivity(i);
        } else {
            Toast.makeText(this, "Elegí una opción", Toast.LENGTH_SHORT).show();
        }

    }
}
