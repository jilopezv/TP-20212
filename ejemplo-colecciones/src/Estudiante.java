public class Estudiante {
    private Integer numeroCarnet;
    private String id;
    private String nombre;

    public Estudiante(Integer numeroCarnet, String id, String nombre) {
        this.numeroCarnet = numeroCarnet;
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getNumeroCarnet() {
        return numeroCarnet;
    }

    public void setNumeroCarnet(Integer numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "numeroCarnet=" + numeroCarnet +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
