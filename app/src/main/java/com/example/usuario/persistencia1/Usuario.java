package com.example.usuario.persistencia1;

import java.io.Serializable;


public class Usuario implements Serializable {

    private String nombre;
    private String apellido;

    public Usuario(){

    }

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (getNombre() != null ? !getNombre().equals(usuario.getNombre()) : usuario.getNombre() != null)
            return false;
        return getApellido() != null ? getApellido().equals(usuario.getApellido()) : usuario.getApellido() == null;

    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getApellido() != null ? getApellido().hashCode() : 0);
        return result;
    }


}
