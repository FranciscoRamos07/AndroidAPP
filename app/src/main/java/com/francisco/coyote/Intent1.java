package com.francisco.coyote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class Intent1 extends AppCompatActivity {




    EditText txtName,txtAge,txtColor;
    CheckBox cbxRemember;


    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);


        txtName=findViewById(R.id.txtIntentName);
        txtAge=findViewById(R.id.txtIntentAge);
        txtColor=findViewById(R.id.txtIntentColor);
        cbxRemember=findViewById(R.id.ckbIntentRemember);
        sendButton=findViewById(R.id.btnIntentSend);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfo();
            }
        });

    }

    private void sendInfo(){
        //Variables locales
        String name, color;
        int age;
        boolean rememberme;

        //Obtener contenido de componentes
        name = txtName.getText().toString();
        color = txtColor.getText().toString();
        age = Integer.parseInt(txtAge.getText().toString());
        rememberme = cbxRemember.isChecked();

        //Enviar info a otra pantalla
        Intent intent = new Intent(Intent1.this, Intent2.class);
        intent.putExtra("intentName", name);
        intent.putExtra("intentColor", color);
        intent.putExtra("intentAge", age);
        intent.putExtra("intentRememberMe", rememberme);
        startActivity(intent);
    }


}