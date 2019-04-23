package com.example.a5en1.Juego1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a5en1.R;

public class MenuJuego1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_1_menu.xml.
        setContentView(R.layout.activity_juego_1_menu);
    }
}
