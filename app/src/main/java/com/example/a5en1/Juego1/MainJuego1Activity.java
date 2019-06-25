package com.example.a5en1.Juego1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.text.Normalizer;

public class MainJuego1Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainJuego1Activity";
    public static final Random RANDOM = new Random();
    private static final int REC_CODE_SPEECH_INPUT = 1000;
    private ArrayList<String> CATEGORIA = new ArrayList<>();
    private String palabraParaEncontrar;
    private String categoriaString;
    private TextView palabraParaValidar;
    private TextView textViewPuntaje;
    private TextView textViewVidas;
    private EditText palabraDigitadaParaValidar;
    private Button arriesgar, pasarPalabra;
    private int cantidadPalabras;
    private int contador = 0;
    private int contadorAciertos = 0;
    private int puntaje = 0;
    private int categoria;
    private short vidas;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_1_main);

        // Encuentra el RelativeLayout del fondo.
        RelativeLayout background = findViewById(R.id.relative_background);

        // Instancia el archivo tecladoxml para poder añadirlo al ViewGroup.
        View child = getLayoutInflater().inflate(R.layout.activity_juego_1_teclado, null);

        // Añade el teclado al fondo.
        background.addView(child);

        imageView = child.findViewById(R.id.image_categoria_normal);
        categoria = getIntent().getIntExtra("CATEGORIA", 0);

        if (categoria == 1) {
            imageView = child.findViewById(R.id.image_categoria_small);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_juego_1_facil);
            vidas = 4;
            categoriaString = getString(R.string.category_facil_juego1);
            CATEGORIA.add("PINTAR");
            CATEGORIA.add("ANILLO");
            CATEGORIA.add("AZUCAR");
            CATEGORIA.add("CABAÑA");
            CATEGORIA.add("GRABAR");
            CATEGORIA.add("IMITAR");
            CATEGORIA.add("VESTIR");
            CATEGORIA.add("ATAQUE");
            CATEGORIA.add("SIRENA");
            CATEGORIA.add("VIAJAR");
            CATEGORIA.add("PINCEL");
            CATEGORIA.add("TOPO");
            CATEGORIA.add("MANO");
            CATEGORIA.add("AZUL");
            CATEGORIA.add("AUTO");
            CATEGORIA.add("ALTO");
            CATEGORIA.add("BOLA");
            CATEGORIA.add("CAJA");
            CATEGORIA.add("EDAD");
            CATEGORIA.add("PATO");
        } else if (categoria == 2) {
            imageView = child.findViewById(R.id.image_categoria_medium);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_juego_1_medio);
            vidas = 3;
            categoriaString = getString(R.string.category_medio_juego1);
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
            CATEGORIA.add("MEDIO");
        } else if (categoria == 3) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_juego_1_dificil);
            vidas = 2;
            categoriaString = getString(R.string.category_dificil_juego1);
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
            CATEGORIA.add("DIFICIL");
        } else if (categoria == 4) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_juego_1_paises);
            vidas = 5;
            categoriaString = getString(R.string.category_paises_juego1);
            CATEGORIA.add("ALEMANIA");
            CATEGORIA.add("ARGENTINA");
            CATEGORIA.add("AUSTRALIA");
            CATEGORIA.add("BELGICA");
            CATEGORIA.add("BOLIVIA");
            CATEGORIA.add("BRASIL");
            CATEGORIA.add("CANADA");
            CATEGORIA.add("CHILE");
            CATEGORIA.add("CHINA");
            CATEGORIA.add("COLOMBIA");
            CATEGORIA.add("CROACIA");
            CATEGORIA.add("DINAMARCA");
            CATEGORIA.add("EGIPTO");
            CATEGORIA.add("ESPAÑA");
            CATEGORIA.add("ESTONIA");
            CATEGORIA.add("FILIPINAS");
            CATEGORIA.add("FINLANDIA");
            CATEGORIA.add("FRANCIA");
            CATEGORIA.add("GRECIA");
            CATEGORIA.add("ISLANDIA");
            CATEGORIA.add("ITALIA");
            CATEGORIA.add("JAPON");
            CATEGORIA.add("LITUANIA");
            CATEGORIA.add("MARRUECOS");
            CATEGORIA.add("MEXICO");
            CATEGORIA.add("NICARAGUA");
            CATEGORIA.add("NIGERIA");
            CATEGORIA.add("NORUEGA");
            CATEGORIA.add("PARAGUAY");
            CATEGORIA.add("PERU");
            CATEGORIA.add("POLONIA");
            CATEGORIA.add("PORTUGAL");
            CATEGORIA.add("RUSIA");
            CATEGORIA.add("SINGAPUR");
            CATEGORIA.add("SUECIA");
            CATEGORIA.add("SUIZA");
            CATEGORIA.add("TURQUIA");
            CATEGORIA.add("UCRANIA");
            CATEGORIA.add("URUGUAY");
            CATEGORIA.add("VENEZUELA");
        } else if (categoria == 5) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_juego_1_animales);
            vidas = 5;
            categoriaString = getString(R.string.category_animales_juego1);
            CATEGORIA.add("RATA");
            CATEGORIA.add("ABEJORRO");
            CATEGORIA.add("ARDILLA");
            CATEGORIA.add("ASNO");
            CATEGORIA.add("AVISPA");
            CATEGORIA.add("BISONTE");
            CATEGORIA.add("BURRO");
            CATEGORIA.add("CABRA");
            CATEGORIA.add("CASTOR");
            CATEGORIA.add("COBAYO");
            CATEGORIA.add("CROACIA");
            CATEGORIA.add("COMADREJA");
            CATEGORIA.add("CERDO");
            CATEGORIA.add("CONEJO");
            CATEGORIA.add("CULEBRA");
            CATEGORIA.add("ESCARABAJO");
            CATEGORIA.add("GALLINA");
            CATEGORIA.add("GANSO");
            CATEGORIA.add("HORMIGA");
            CATEGORIA.add("LAGARTIJA");
            CATEGORIA.add("LIBELULA");
            CATEGORIA.add("LIEBRE");
            CATEGORIA.add("LUCIERNAGA");
            CATEGORIA.add("GACELA");
            CATEGORIA.add("MAPACHE");
            CATEGORIA.add("MARIPOSA");
            CATEGORIA.add("MURCIELAGO");
            CATEGORIA.add("NUTRIA");
            CATEGORIA.add("SALAMANDRA");
            CATEGORIA.add("SALTAMONTES");
            CATEGORIA.add("SANGUIJUELA");
            CATEGORIA.add("PALOMA");
            CATEGORIA.add("AGUILA");
            CATEGORIA.add("CACATÚA");
            CATEGORIA.add("PELICANO");
            CATEGORIA.add("CONDOR");
            CATEGORIA.add("FLAMENCO");
            CATEGORIA.add("GOLONDRINA");
            CATEGORIA.add("LECHUZA");
            CATEGORIA.add("PAPAGAYO");
        }

        cantidadPalabras = CATEGORIA.size();

        // Encuentra el EditView que muestra la palabra ingresada por el usuario.
        palabraDigitadaParaValidar = child.findViewById(R.id.edit_palabra_digitada_para_validar);

        // Encuentra el TextView que muestra la palabra para validar.
        palabraParaValidar = findViewById(R.id.text_palabra_para_validar);

        // Encuentra el TextView que muestra el puntaje.
        textViewPuntaje = findViewById(R.id.puntaje);

        // Encuentra el TextView que muestra las vidas restantes.
        textViewVidas = findViewById(R.id.vidas);

        // Encuentra el TextView que muestra la categoria.
        TextView textViewCategoria = findViewById(R.id.categoria);

        // Encuentra el Botón que se utiliza para arriesgar una palabra.
        arriesgar = findViewById(R.id.arriesgar);

        // Establece un click listener en ese Botón.
        arriesgar.setOnClickListener(this);

        // Encuentra el Botón que se utiliza para pasar la palabra si no se sabe.
        pasarPalabra = findViewById(R.id.saltar_palabra);

        // Establece un click listener en ese Botón.
        pasarPalabra.setOnClickListener(this);

        textViewVidas.setText("" + vidas);

        textViewCategoria.setText(categoriaString);

        textViewPuntaje.setText("" + puntaje);

        ImageButton mBotonHablar = findViewById(R.id.botonHablar);

        mBotonHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }
        });

        // Ejecuta el método para generar una nueva palabra.
        nuevaPalabra();
    }

    // (Speech to Text)
    private void iniciarEntradaVoz() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "¿Que palabra es?");
        try {
            startActivityForResult(intent, REC_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "No se encontró ninguna actividad");
        }
    }

    // (Speech to Text)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REC_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String resultWord = result.get(0).toUpperCase();
                palabraDigitadaParaValidar.setText(resultWord);
            }
        }
    }

    public String sacarAcentos(String string) {
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "");
        return string;
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
            textViewPuntaje.setText("" + puntaje);
            nuevaPalabra();
            contador++;
        }
        if (contador == cantidadPalabras) {
            abrirReultados();
        }
    }

    private void verificar() {
        String p = sacarAcentos(palabraDigitadaParaValidar.getText().toString().toUpperCase().trim());
        String q = sacarAcentos(palabraParaEncontrar);
        if (q.equals(p)) {
            Toast toast = Toast.makeText(this, "Correcto! Adivinaste la palabra: " + palabraParaEncontrar, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -450);
            toast.show();
            puntaje += 300;
            contadorAciertos++;
            textViewPuntaje.setText("" + puntaje);
            nuevaPalabra();
        } else {
            if (categoria == 3) {
                Toast toast = Toast.makeText(this, "Incorrecto! Palabra equivocada", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, -450);
                toast.show();
            } else {
                Toast toast = Toast.makeText(this, "Incorrecto! la palabra era " + palabraParaEncontrar, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, -450);
                toast.show();
                puntaje -= 200;
                vidas--;
                if (vidas == 0) {
                    abrirReultados();
                }
                textViewPuntaje.setText("" + puntaje);
                textViewVidas.setText("" + vidas);
                nuevaPalabra();
            }
        }
    }

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
            char[] a = palabra.toCharArray();

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

    // Metodo del boton "back"
    @Override
    public void onBackPressed() {
        // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
        Intent menuCategoriasIntent = new Intent(MainJuego1Activity.this, MenuJuego1Activity.class);
        // Inicia la nueva Activity
        startActivity(menuCategoriasIntent);
    }

    public void backButton(View view) {
        // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
        Intent menuCategoriasIntent = new Intent(MainJuego1Activity.this, MenuJuego1Activity.class);
        // Inicia la nueva Activity
        startActivity(menuCategoriasIntent);
    }

}