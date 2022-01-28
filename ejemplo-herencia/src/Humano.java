public class Humano extends Animal implements Volable {
    public Humano(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerRuido() {
        System.out.println("bla bla bla");
    }

    @Override
    public void volar() {
        System.out.println("Vuelo en avión");
    }
}
