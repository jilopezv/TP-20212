package co.edu.udea.tecnicas.introduccionjavafx.model;

public class Persona {
    private Integer id;
    private String nombres;

    public Persona(Integer id, String nombres) {
        this.id = id;
        this.nombres = nombres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}
