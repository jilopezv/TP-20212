public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }

    public void pasear() {
        System.out.println("Paseo como perro");
    }

    public void hacerRuido() {
        System.out.println("Ladro como perro");
    }
}
