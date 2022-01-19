public class Principal {

    public static void main(String[] args) {
        Animal a = new Animal("animal 1");
        a.comer();
        a.dormir();
        a.hacerRuido();

        Perro p = new Perro();
        p.pasear();
        p.comer();
        p.dormir();
        p.hacerRuido();

        Gato g = new Gato();
        g.trepar();
        g.comer();
        g.dormir();
        g.hacerRuido();
    }
}
