public class Gato extends Animal {

    public Gato(String nombre) {
        super(nombre);
    }

    public Gato() {
        super("NN");
    }

    public void trepar() {
        System.out.println("Trepo como gato");
    }

    public void hacerRuido() {
        System.out.println("... y, además, Maullo como gato");
    }
}
