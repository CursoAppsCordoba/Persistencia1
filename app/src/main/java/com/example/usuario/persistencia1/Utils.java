package com.example.usuario.persistencia1;

import android.app.Activity;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
}
