package com.example.usuario.persistencia1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ArrayList<Usuario> usuarios = Utils.leerUsuarios(this);
        if (usuarios == null) {
            usuarios = new ArrayList<>();

            usuarios.add(Utils.crearUsuario(this));
            Utils.crearArchivo(this, usuarios);



            //Intent intent = new Intent(this, DestinoActivity.class);
            //startActivity(intent);
        }else{

            usuarios.add(Utils.crearUsuario(this));
            Utils.crearArchivo(this, usuarios);
        }
    }
}
