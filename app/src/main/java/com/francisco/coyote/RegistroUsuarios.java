package com.francisco.coyote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroUsuarios extends AppCompatActivity {

    EditText name, email,pass;
    Button signup;

    TextView gotoLogin;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);


        mAuth = FirebaseAuth.getInstance();


        name= findViewById(R.id.nameTxt);
        email= findViewById(R.id.correoTxt);
        pass= findViewById(R.id.pwdTxt);
        signup= findViewById(R.id.btnSignUp);
        //gotoLogin= findViewById(R.id.);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpMethod(email.getText().toString(),pass.getText().toString());
            }
        });

    }

    private void signUpMethod(String emailText, String passText) {
        if(!emailText.isEmpty()&& !passText.isEmpty()){
            if(passText.length()>6){
                mAuth.createUserWithEmailAndPassword(emailText, passText)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(RegistroUsuarios.this, LoginUsuarios.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(RegistroUsuarios.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        }


    }


}






