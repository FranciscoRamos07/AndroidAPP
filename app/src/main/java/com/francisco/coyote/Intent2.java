package com.francisco.coyote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Intent2 extends AppCompatActivity {

    TextView txtName, txtAge,txtColor;
    CheckBox cbxRemember;

    CardView layoutColor;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        Intent intent = getIntent();

        txtName = findViewById(R.id.textName);
        txtAge = findViewById(R.id.textAge);
        txtColor = findViewById(R.id.textColor);
        cbxRemember = findViewById(R.id.cbxRemember);
        layoutColor = findViewById(R.id.color);

        //Asignar valores a componentes

        txtName.setText(intent.getStringExtra("intentName"));

        //Validacion de edad
        String ageText = "No se encontro edad";
        if(intent.getIntExtra("intentAge", 0) != 0){
            ageText = "Edad: " + intent.getIntExtra("intentAge", 0);
        }
        txtAge.setText(ageText);

        txtColor.setText(intent.getStringExtra("intentColor"));
        cbxRemember.setChecked(intent.getBooleanExtra("intentRememberMe", false));

        if(intent.getStringExtra("intentColor").contains("#")){
            try{
                layoutColor.setBackgroundColor(Color.parseColor(intent.getStringExtra("intentColor")));
            }catch(Exception e){
                Toast.makeText(this,e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }

        layoutColor.setBackgroundColor(Color
                .parseColor(intent.getStringExtra("intentColor")));


        String name = intent.getStringExtra("intentName");
        int age = intent.getIntExtra("intentAge", 0);

       // Toast.makeText(Intent2.this, name + " = " + age,
       // Toast.LENGTH_SHORT).show();
    }
}

