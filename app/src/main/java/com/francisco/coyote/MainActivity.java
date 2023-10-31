package com.francisco.coyote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables
    TextView holamundo;
    Button btnExplicito;
    Button btnExplicit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("holamundo","onCreate");

        //inicializacion de variables y enlace de componentes
        holamundo = findViewById(R.id.txtHolaMundo);
        btnExplicito = findViewById(R.id.btnExplicito);
        btnExplicit = findViewById(R.id.btnExplicit);

        //evento click
        btnExplicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                //finish(); se utiliza para destruir la actv en contexto
            }
        });


        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=El+padrino&oq=El+padrino+&gs_lcrp=EgZjaHJvbWUyDAgAEEUYORixAxiABDIKCAEQABixAxiABDIKCAIQABixAxiABDIKCAMQABixAxiABDIHCAQQABiABDIKCAUQABixAxiABDIGCAYQRRg8MgYIBxBFGDwyBggIEEUYPNIBCDIyNTJqMGoxqAIAsAIA&sourceid=chrome&ie=UTF-8"));
                startActivity(i);
                //finish(); se utiliza para destruir la actv en contexto
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("holamundo","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("holamundo","onStart");
        holamundo.setText("Hola Mundo Desde Clase Java En Metodo OnResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("holamundo","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("holamundo","onDestroy");
    }

}