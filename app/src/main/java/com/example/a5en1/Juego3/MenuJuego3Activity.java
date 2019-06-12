package com.example.a5en1.Juego3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a5en1.R;

import java.util.Arrays;
import java.util.Collections;

public class MenuJuego3Activity extends AppCompatActivity {

    ImageView iv_11, iv_12, iv_13,
            iv_21, iv_22, iv_23,
            iv_31, iv_32, iv_33,
            iv_41, iv_42, iv_43;
    Integer cardsArray[] = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_3_menu.xml.
        setContentView(R.layout.activity_juego_3_menu);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");
        iv_31.setTag("6");
        iv_32.setTag("7");
        iv_33.setTag("8");
        iv_41.setTag("9");
        iv_42.setTag("10");
        iv_43.setTag("11");

        Collections.shuffle(Arrays.asList(cardsArray));

        frontOfCardResource();

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11, theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12, theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13, theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21, theCard);
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22, theCard);
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23, theCard);
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31, theCard);
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32, theCard);
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_33, theCard);
            }
        });
        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41, theCard);
            }
        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42, theCard);
            }
        });
        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_43, theCard);
            }
        });
    }

    private void doStuff(ImageView iv, int card){
        if(cardsArray[card]==101){
            iv.setImageResource(image101);
        } else if(cardsArray[card]==102){
            iv.setImageResource(image102);
        } else if(cardsArray[card]==103){
            iv.setImageResource(image103);
        } else if(cardsArray[card]==104){
            iv.setImageResource(image104);
        } else if(cardsArray[card]==105){
            iv.setImageResource(image105);
        } else if(cardsArray[card]==106){
            iv.setImageResource(image106);
        } else if(cardsArray[card]==201) {
            iv.setImageResource(image201);
        } else if(cardsArray[card]==202){
            iv.setImageResource(image202);
        } else if(cardsArray[card]==203){
            iv.setImageResource(image203);
        } else if(cardsArray[card]==204){
            iv.setImageResource(image204);
        } else if(cardsArray[card]==205){
            iv.setImageResource(image205);
        } else if(cardsArray[card]==206){
            iv.setImageResource(image206);
        }

        if(cardNumber == 1){
            firstCard = cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2){
            secondCard = cardsArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);
        }
    }

    private  void calculate(){
        if(firstCard == secondCard){
            if(clickedFirst == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 1){
                iv_12.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 2){
                iv_13.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 3){
                iv_21.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 4){
                iv_22.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 5){
                iv_23.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 6){
                iv_31.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 7){
                iv_32.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 8){
                iv_33.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 9){
                iv_41.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 10){
                iv_42.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 11){
                iv_43.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 1){
                iv_12.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 2){
                iv_13.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 3){
                iv_21.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 4){
                iv_22.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 5){
                iv_23.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 6){
                iv_31.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 7){
                iv_32.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 8){
                iv_33.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 9){
                iv_41.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 10){
                iv_42.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 11){
                iv_43.setVisibility(View.INVISIBLE);
            }

        } else {
            iv_11.setImageResource(R.drawable.ic_back);
            iv_12.setImageResource(R.drawable.ic_back);
            iv_13.setImageResource(R.drawable.ic_back);
            iv_21.setImageResource(R.drawable.ic_back);
            iv_22.setImageResource(R.drawable.ic_back);
            iv_23.setImageResource(R.drawable.ic_back);
            iv_31.setImageResource(R.drawable.ic_back);
            iv_32.setImageResource(R.drawable.ic_back);
            iv_33.setImageResource(R.drawable.ic_back);
            iv_41.setImageResource(R.drawable.ic_back);
            iv_42.setImageResource(R.drawable.ic_back);
            iv_43.setImageResource(R.drawable.ic_back);

        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if( iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuJuego3Activity.this);
            alertDialogBuilder
                    .setMessage("Fin del Juego")
                    .setCancelable(false)
                    .setPositiveButton("Nuevo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MenuJuego3Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void frontOfCardResource(){
        image101 = R.drawable.ic_101;
        image102 = R.drawable.ic_102;
        image103 = R.drawable.ic_103;
        image104 = R.drawable.ic_104;
        image105 = R.drawable.ic_105;
        image106 = R.drawable.ic_106;
        image201 = R.drawable.ic_201;
        image202 = R.drawable.ic_202;
        image203 = R.drawable.ic_203;
        image204 = R.drawable.ic_204;
        image205 = R.drawable.ic_205;
        image206 = R.drawable.ic_206;
    }
}