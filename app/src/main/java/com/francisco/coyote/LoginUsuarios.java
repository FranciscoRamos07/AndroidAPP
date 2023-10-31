package com.francisco.coyote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUsuarios extends AppCompatActivity {


    EditText email, pass;
    Button login, registro;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuarios);

        email = findViewById(R.id.emailTxt);
        pass = findViewById(R.id.passwordTxt);
        login = findViewById(R.id.accederBtn);
        registro = findViewById(R.id.registroBtn);

        mAuth = FirebaseAuth.getInstance();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInMethod(email.getText().toString(),pass.getText().toString());
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginUsuarios.this, RegistroUsuarios.class);
                startActivity(intent);
            }
        });

    }



    private void signInMethod(String emailText, String passText) {
        if(!emailText.isEmpty()&& !passText.isEmpty()){
            mAuth.signInWithEmailAndPassword(emailText, passText)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LoginUsuarios.this, "Acceso Correcto.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginUsuarios.this, Home.class);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(LoginUsuarios.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


        }


    }


}