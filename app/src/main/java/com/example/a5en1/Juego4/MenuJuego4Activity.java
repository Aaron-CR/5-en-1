package com.example.a5en1.Juego4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a5en1.R;

public class MenuJuego4Activity extends AppCompatActivity {

    private TextView contadores;
    int plata= 5;
    int hambre= 5;
    int diversion= 5;
    int social= 5;
    int facultad= 5;
    int sueño= 5;
    int salud= 5;
    int tiempo= 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_4_menu);

        contadores= (TextView) findViewById(R.id.txt_cont);
        contadores.setText("Plata: "+plata+"\nHambre: "+hambre+"\nDiversión: "+diversion+"\nSocial: "+social+"\nFacultad: "+facultad+"\nSueño: "+sueño+"\nSalud: "+salud+"\nTiempo: "+tiempo);
    }

    public void empezar(View view){
        Intent i= new Intent(this, Juego4Activity1.class);
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
