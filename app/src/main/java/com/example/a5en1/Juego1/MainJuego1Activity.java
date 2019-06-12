package com.example.a5en1.Juego1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainJuego1Activity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> CATEGORIA = new ArrayList<>();
    private String palabraParaEncontrar;
    private String categoriaString;
    private View child;
    private RelativeLayout background;
    private LinearLayout teclado;
    private TextView palabraParaValidar;
    private TextView textViewPuntaje;
    private TextView textViewVidas;
    private TextView textViewCategoria;
    private EditText palabraDigitadaParaValidar;
    private Button arriesgar, pasarPalabra;
    private ImageButton mBotonHablar;
    private static final int REC_CODE_SPEECH_INPUT = 1000;
    private int cantidadPalabras;
    private int contador = 0;
    private int contadorAciertos = 0;
    private int puntaje = 0;
    private int categoria;
    private short vidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_1_main);

        categoria = getIntent().getIntExtra("CATEGORIA", 0);

        if (categoria == 1) {
            vidas = 4;
            categoriaString = getString(R.string.category_facil_juego1);
            CATEGORIA.add("Facil");
            CATEGORIA.add("Facil");
            CATEGORIA.add("Facil");
            CATEGORIA.add("Facil");
            CATEGORIA.add("Facil");
        } else if (categoria == 2) {
            vidas = 3;
            categoriaString = getString(R.string.category_medio_juego1);
            CATEGORIA.add("Medio");
            CATEGORIA.add("Medio");
            CATEGORIA.add("Medio");
            CATEGORIA.add("Medio");
            CATEGORIA.add("Medio");
        } else if (categoria == 3) {
            vidas = 2;
            categoriaString = getString(R.string.category_dificil_juego1);
            CATEGORIA.add("Dificil");
            CATEGORIA.add("Dificil");
            CATEGORIA.add("Dificil");
            CATEGORIA.add("Dificil");
            CATEGORIA.add("Dificil");
        } else if (categoria == 4) {
            vidas = 5;
            categoriaString = getString(R.string.category_paises_juego1);
            CATEGORIA.add("ALEMANIA");
            CATEGORIA.add("ARGENTINA");
            CATEGORIA.add("AUSTRALIA");
            CATEGORIA.add("BÉLGICA");
            CATEGORIA.add("BOLIVIA");
        } else if (categoria == 5) {
            vidas = 5;
            categoriaString = getString(R.string.category_animales_juego1);
            CATEGORIA.add("RATA");
            CATEGORIA.add("ABEJORRO");
            CATEGORIA.add("ARDILLA");
            CATEGORIA.add("ASNO");
            CATEGORIA.add("AVISPA");
        }

        cantidadPalabras = CATEGORIA.size();

        // Encuentra el RelativeLayout del fondo.
        background = findViewById(R.id.relative_background);

        // Instancia el archivo tecladoxml para poder añadirlo al ViewGroup.
        child = getLayoutInflater().inflate(R.layout.activity_juego_1_teclado, null);

        // Añade el teclado al fondo.
        background.addView(child);

        // Encuentra el Layout del teclado.
        teclado = child.findViewById(R.id.teclado);

        // Encuentra el EditView que muestra la palabra ingresada por el usuario.
        palabraDigitadaParaValidar = child.findViewById(R.id.edit_palabra_digitada_para_validar);

        // Encuentra el TextView que muestra la palabra para validar.
        palabraParaValidar = findViewById(R.id.text_palabra_para_validar);

        // Encuentra el TextView que muestra el puntaje.
        textViewPuntaje = findViewById(R.id.puntaje);

        // Encuentra el TextView que muestra las vidas restantes.
        textViewVidas = findViewById(R.id.vidas);

        // Encuentra el TextView que muestra la categoria.
        textViewCategoria = findViewById(R.id.categoria);

        // Encuentra el Botón que se utiliza para arriesgar una palabra.
        arriesgar = findViewById(R.id.arriesgar);

        // Establece un click listener en ese Botón.
        arriesgar.setOnClickListener(this);

        // Encuentra el Botón que se utiliza para pasar la palabra si no se sabe.
        pasarPalabra = findViewById(R.id.saltar_palabra);

        // Establece un click listener en ese Botón.
        pasarPalabra.setOnClickListener(this);

        textViewVidas.setText("V " + vidas);

        textViewCategoria.setText(categoriaString);

        textViewPuntaje.setText("P " + puntaje);

        mBotonHablar = findViewById(R.id.botonHablar);

        mBotonHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }
        });

        // Ejecuta el método para generar una nueva palabra.
        nuevaPalabra();

    }

    // (Entrada de voz)

    private void iniciarEntradaVoz() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "¿Que palabra es?");
        try {
            startActivityForResult(intent, REC_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REC_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    palabraDigitadaParaValidar.setText(result.get(0));
                }
                break;
            }
        }
    }

    // (Teclado)
    public void onTapped(View view) {
        Button button = (Button) view;
        if (button.getText().equals("del")) {
            if (palabraDigitadaParaValidar.getText().length() > 0)
                palabraDigitadaParaValidar.setText(palabraDigitadaParaValidar.getText().toString().substring(0, palabraDigitadaParaValidar.getText().length() - 1));
            palabraDigitadaParaValidar.setSelection(palabraDigitadaParaValidar.getText().length());
        } else
            palabraDigitadaParaValidar.setText(palabraDigitadaParaValidar.getText() + "" + button.getText().toString().toUpperCase());
        palabraDigitadaParaValidar.setSelection(palabraDigitadaParaValidar.getText().length());
    }

    @Override
    public void onClick(View view) {
        if (view == arriesgar) {
            verificar();
            contador++;
        } else if (view == pasarPalabra) {
            puntaje -= 100;
            textViewPuntaje.setText("P " + puntaje);
            nuevaPalabra();
            contador++;
        }
        if (contador == cantidadPalabras) {
            abrirReultados();
        }
    }


    private void verificar() {
        String p = palabraDigitadaParaValidar.getText().toString().toUpperCase().trim();
        if (palabraParaEncontrar.equals(p)) {
            Toast.makeText(this, "Correcto! Adivinaste la palabra: " + palabraParaEncontrar, Toast.LENGTH_SHORT).show();
            puntaje += 300;
            contadorAciertos++;
            textViewPuntaje.setText("P " + puntaje);
            nuevaPalabra();
        } else {
            if (categoria == 3) {
                Toast.makeText(this, "Incorrecto! Palabra equivocada", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Incorrecto! la palabra era " + palabraParaEncontrar, Toast.LENGTH_SHORT).show();
            puntaje -= 200;
            vidas--;
            if (vidas == 0) {
                abrirReultados();
            }
            textViewPuntaje.setText("P " + puntaje);
            textViewVidas.setText("V " + vidas);
            nuevaPalabra();
        }
    }

    private void nuevaPalabra() {
        palabraParaEncontrar = palabraAleatoria(CATEGORIA);
        String palabraMezclada = mezclarPalabra(palabraParaEncontrar);
        palabraParaValidar.setText(palabraMezclada);
        palabraDigitadaParaValidar.setText("");
    }

    private void abrirReultados() {
        // Crea un Intent para abrir {@link ResultadosJuego1Activity}
        Intent resultadosIntent = new Intent(MainJuego1Activity.this, ResultadosJuego1Activity.class);
        resultadosIntent.putExtra("CONTADOR_RESPUESTA_CORRECTA", contadorAciertos);
        resultadosIntent.putExtra("CANTIDAD_PALABRAS", cantidadPalabras);
        resultadosIntent.putExtra("PUNTAJE_TOTAL", puntaje);
        resultadosIntent.putExtra("CATEGORIA", categoria);
        // Inicia la Activity
        startActivity(resultadosIntent);
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
}