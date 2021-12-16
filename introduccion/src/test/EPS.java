package test;

import java.util.ArrayList;
import java.util.List;

public class EPS {
    private String nit;
    private String nombre;
    private String direccionPpal;
    private String telefonoPpal;

    // asociación con la clase Empleado
    private List<Empleado> empleados;

    public EPS(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        // inicializamos la variable empleados
        empleados = new ArrayList();
    }

    public EPS(String nit, String nombre, String direccionPpal, String telefonoPpal) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccionPpal = direccionPpal;
        this.telefonoPpal = telefonoPpal;
        // inicializamos la variable empleados
        empleados = new ArrayList();
    }

    public void afiliarEmpleado(Empleado empleado){
        // TODO: validar que el empleado no esté afiliado previamente
        this.empleados.add(empleado);
    }


    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionPpal() {
        return direccionPpal;
    }

    public void setDireccionPpal(String direccionPpal) {
        this.direccionPpal = direccionPpal;
    }

    public String getTelefonoPpal() {
        return telefonoPpal;
    }

    public void setTelefonoPpal(String telefonoPpal) {
        this.telefonoPpal = telefonoPpal;
    }

    @Override
    public String toString() {
        return this.nit + " - "+ this.nombre;
    }
}
