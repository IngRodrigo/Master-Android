package com.jx3.a01_iniciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btn_login;
private EditText email, password;
private String emailText, passwordTex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectarVista();
        establecerListener();
    }
    //ciclos de vida de un activity

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void conectarVista(){
        this.btn_login=findViewById(R.id._main_btn_login);
        this.email=findViewById(R.id._main_email);
        this.password=findViewById(R.id._main_password);
    }
    private void establecerListener(){
        this.btn_login.setOnClickListener(this);
    }

    private boolean comprobarTextosVacios(){
        this.emailText=email.getText().toString();
        this.passwordTex=password.getText().toString();
        boolean resultado=false;
        if(!emailText.isEmpty() && !passwordTex.isEmpty()){
            resultado=true;
        }
        return resultado;
    }
    private void ejecutarIntentIrLogin(){
        Intent intentLogin= new Intent(getApplicationContext(), HomeActivity.class);
        intentLogin.putExtra("valorEmail", emailText);
        startActivity(intentLogin);
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id._main_btn_login){
            if(comprobarTextosVacios()){
                ejecutarIntentIrLogin();
            }else{
                email.setError("Complete el email y la contraseña");
                Toast.makeText(getApplicationContext(), "Las credenciales no pueden estar vacias", Toast.LENGTH_SHORT).show();
            }
        }
    }
}