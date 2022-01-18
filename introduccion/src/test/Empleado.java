package test;

public class Empleado {
    private String id;
    private String nombres;
    private String apellidos;
    private double salario;
    private double peso;
    private double estatura;
    private String cargo;
    private String profesion;

    // asociación con la clase EPS
    private EPS eps;

    public Empleado() {
        System.out.println("Me crearon");
        id = "111";
    }

    // constructor sobrecargado
    public Empleado(String id, String nombres, String apellidos, String cargo) {
        System.out.println("Me crearon con el constructor 2");
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public EPS getEps() {
        return this.eps;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            System.out.println("Salario inválido ");
            return;
        }
        this.salario = salario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getSalario() {
        return salario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cargo='" + cargo + '\'' +
                ", eps=" + eps;
    }
}
