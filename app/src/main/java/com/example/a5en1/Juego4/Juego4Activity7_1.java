package com.example.a5en1.Juego4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

public class Juego4Activity7_1 extends AppCompatActivity {

    private RadioButton rb1, rb2, rb3;
    private TextView contadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_4_7_1);

        int plata = getIntent().getIntExtra("plata", 5);
        int hambre = getIntent().getIntExtra("hambre", 5);
        int diversion = getIntent().getIntExtra("diversion", 5);
        int social = getIntent().getIntExtra("social", 5);
        int facultad = getIntent().getIntExtra("facultad", 5);
        int sueño = getIntent().getIntExtra("sueño", 5);
        int salud = getIntent().getIntExtra("salud", 5);
        int tiempo = getIntent().getIntExtra("tiempo", 5);
        rb1 = (RadioButton) findViewById(R.id.rb_7_1a);
        rb2 = (RadioButton) findViewById(R.id.rb_7_1b);
        rb3 = (RadioButton) findViewById(R.id.rb_7_1c);
        contadores = (TextView) findViewById(R.id.txt_cont7_1);
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
            diversion++;
            Toast.makeText(this, "+diversión", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Juego4Activity8_1_1.class);
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
            tiempo--;
            Toast.makeText(this, "-tiempo", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Juego4Activity8_1_2.class);
            i.putExtra("plata", plata);
            i.putExtra("hambre", hambre);
            i.putExtra("diversion", diversion);
            i.putExtra("social", social);
            i.putExtra("facultad", facultad);
            i.putExtra("sueño", sueño);
            i.putExtra("salud", salud);
            i.putExtra("tiempo", tiempo);
            startActivity(i);
        } else if (rb3.isChecked() == true) {
            diversion++; social--;
            Toast.makeText(this, "+diversión, -social", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Juego4Activity8_1_3.class);
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
