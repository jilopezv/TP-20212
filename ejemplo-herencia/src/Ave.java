public class Ave extends Animal implements Volable {

    public Ave(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerRuido() {
        System.out.println("canto como un ave");
    }

    @Override
    public void volar() {
        System.out.println("vuelo como ave");
    }
}
