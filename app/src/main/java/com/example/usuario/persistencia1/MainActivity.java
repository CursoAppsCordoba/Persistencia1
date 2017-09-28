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
        try {

        }


        try (FileOutputStream out = this.openFileOutput("Usuario.dat", this.MODE_PRIVATE); ObjectOutputStream file = new ObjectOutputStream(out)){

            EditText et_name = (EditText) findViewById(R.id.et_name);
            EditText et_last = (EditText) findViewById(R.id.et_last);

            String nombre, apellido;

            nombre = et_name.getText().toString();
            apellido = et_last.getText().toString();

            Usuario user = new Usuario(nombre, apellido);

            file.writeObject(user);
            file.close();
            Intent intent = new Intent(this, DestinoActivity.class);
            startActivity(intent);

        } catch (FileNotFoundException e) {
            Toast.makeText(this, "El fichero no existe compi", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Ha fallado el ObjectXXX y tal", Toast.LENGTH_LONG).show();
        }
    }
}
