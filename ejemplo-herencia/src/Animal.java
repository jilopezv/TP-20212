public class Animal {

    private String nombre;

    public Animal(){
        this.nombre = "NN";
    }

    public Animal(String nombre){
        this.nombre = nombre;
    }

    public void hacerRuido(){
        System.out.println("Hago ruido como animal");
    }

    public void comer(){
        System.out.println("Como como animal");
    }

    public void dormir(){
        System.out.println("Duermo como animal");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
