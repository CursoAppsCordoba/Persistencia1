package com.example.usuario.persistencia1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DestinoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);
        TextView tv = (TextView) findViewById(R.id.textView3);
        //Usuario usuario = Utils.leerUser(this);
        //tv.setText(usuario.getNombre() + " " + usuario.getApellido());
    }
}
