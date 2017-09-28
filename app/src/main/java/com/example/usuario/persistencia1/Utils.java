package com.example.usuario.persistencia1;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utils {



    public static ArrayList<Usuario> leerUsuarios(Activity activity){
        ObjectInputStream item = null;
        ArrayList<Usuario> usuarios = null;
        try {
            FileInputStream in = activity.openFileInput("Usuario.dat");
            item = new ObjectInputStream(in);
            usuarios = (ArrayList<Usuario>) item.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(item != null){
                    item.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return usuarios;
        }
    }

    public static Usuario crearUsuario(Activity activity){
        EditText et_name = (EditText) activity.findViewById(R.id.et_name);
        EditText et_last = (EditText) activity.findViewById(R.id.et_last);

        String nombre, apellido;

        nombre = et_name.getText().toString();
        apellido = et_last.getText().toString();

        Usuario user = new Usuario(nombre, apellido);

        return user;
    }

    public static void crearArchivo(Activity activity, ArrayList<Usuario> listaUsuarios){
        try (FileOutputStream out = activity.openFileOutput("Usuario.dat", activity.MODE_PRIVATE);
             ObjectOutputStream file = new ObjectOutputStream(out)) {

            if (listaUsuarios == null){
                listaUsuarios = new ArrayList<>();
            }
            file.writeObject(listaUsuarios);
            file.close();

        } catch (FileNotFoundException e) {
            Toast.makeText(activity, "El fichero no existe compi", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(activity, "Ha fallado el ObjectXXX y tal", Toast.LENGTH_LONG).show();
        }
    }
}
