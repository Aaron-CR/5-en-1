package com.example.a5en1.Juego1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

import java.util.ArrayList;
import java.util.Random;

public class MainJuego1Activity extends AppCompatActivity implements View.OnClickListener {

    private static ArrayList<String> CATEGORIA = new ArrayList<>();
    private String palabraParaEncontrar;
    private TextView palabraParaValidar;
    private EditText palabraDigitadaParaValidar;
    private Button arriesgar, pasarPalabra;
    private int categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_1_menu.xml.
        setContentView(R.layout.activity_juego_1_menu);

        categoria = getIntent().getIntExtra("CATEGORIA", 0);

        if (categoria == 1) {
            CATEGORIA.add("Facil");
        } else if (categoria == 2) {
            CATEGORIA.add("Medio");
            CATEGORIA.add("Medio");
        } else if (categoria == 3) {
            CATEGORIA.add("Dificil");
            CATEGORIA.add("Dificil");
        } else if (categoria == 4) {
            CATEGORIA.add("ALEMANIA");
            CATEGORIA.add("ARGENTINA");
            CATEGORIA.add("AUSTRALIA");
            CATEGORIA.add("BÉLGICA");
            CATEGORIA.add("BOLIVIA");
        } else if (categoria == 5) {
            CATEGORIA.add("RATA");
            CATEGORIA.add("ABEJORRO");
            CATEGORIA.add("ARDILLA");
            CATEGORIA.add("ASNO");
            CATEGORIA.add("AVISPA");
        }

        // Encuentra el View que muestra la palabra para validar.
        palabraParaValidar = (TextView) findViewById(R.id.palabra_para_validar);

        // Encuentra el View que muestra la palabra ingresada por el usuario.
        palabraDigitadaParaValidar = (EditText) findViewById(R.id.palabra_digitada);

        // Encuentra el Botón que se utiliza para arriesgar una palabra.
        arriesgar = (Button) findViewById(R.id.arriesgar);

        /** Establece un click listener en ese Botón. */
        arriesgar.setOnClickListener(this);

        // Encuentra el Botón que se utiliza para pasar la palabra si no se sabe.
        pasarPalabra = (Button) findViewById(R.id.pasar_palabra);

        // Establece un click listener en ese Botón.
        pasarPalabra.setOnClickListener(this);

        // Ejecuta el método para generar una nueva palabra.
        nuevaPalabra();

    }

    private void nuevaPalabra() {
        palabraParaEncontrar = palabraAleatoria(CATEGORIA);
        String palabraMezclada = mezclarPalabra(palabraParaEncontrar);
        palabraParaValidar.setText(palabraMezclada);
        palabraDigitadaParaValidar.setText("");
    }

    public static final Random RANDOM = new Random();

    public static String palabraAleatoria(ArrayList<String> CATEGORIA) {
        int r = RANDOM.nextInt(CATEGORIA.size());

        String p = String.valueOf(CATEGORIA.get(r));
        if (CATEGORIA.size() != 1) {
            CATEGORIA.remove(r);
        }
        return p;
    }

    public static String mezclarPalabra(String palabra) {
        if (palabra != null && !"".equals(palabra)) {
            char a[] = palabra.toCharArray();

            for (int i = 0; i < a.length; i++) {
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }

        return palabra;
    }

    public void onClick(View view) {
        if (view == arriesgar) {
            verificar();
        } else if (view == pasarPalabra) {
            nuevaPalabra();
        }
    }

    private void verificar() {
        String p = palabraDigitadaParaValidar.getText().toString().toUpperCase().trim();

        if (palabraParaEncontrar.equals(p)) {
            Toast.makeText(this, "Felicitaciones ! Adivinaste la palabra " + palabraParaEncontrar, Toast.LENGTH_SHORT).show();
            nuevaPalabra();
        } else {
            Toast.makeText(this, "Palabra equivocada!", Toast.LENGTH_SHORT).show();
            nuevaPalabra();
        }
    }

}