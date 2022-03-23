package co.edu.udea.tecnicas.ejemploborderpane.model;

import java.util.List;

public class Usuario {
    private Integer identificacion;
    private String nombres;
    private String apellidos;
    private String correo;

    // atributo para la relación con Direccion
    private List<Direccion> direcciones;

    public Usuario(Integer identificacion, String nombres, String apellidos, String correo) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }


    @Override
    public String toString() {
        return this.identificacion + " - " + this.getNombres();
    }

}
