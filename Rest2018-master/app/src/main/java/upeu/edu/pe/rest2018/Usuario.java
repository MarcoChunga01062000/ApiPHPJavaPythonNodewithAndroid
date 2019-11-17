package upeu.edu.pe.rest2018;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {


    private int idusuario;

    private String nombres;

    private String correo;

    private String pass;

    private String origen;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombres, String correo, String pass, String origen) {
        this.idusuario = idusuario;
        this.nombres = nombres;
        this.correo = correo;
        this.pass = pass;
        this.origen = origen;
    }

    public Usuario(String nombres, String correo, String pass, String origen) {
        this.nombres = nombres;
        this.correo = correo;
        this.pass = pass;
        this.origen = origen;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return nombres + " - " + correo + " - " + origen;
    }
}
