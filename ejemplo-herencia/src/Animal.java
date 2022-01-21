public abstract class Animal {

    // # puede ser accedido por la misma clase y las hijas
    protected String nombre;

    public Animal(String nombre){
        this.nombre = nombre;
    }

    public abstract void hacerRuido();

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
