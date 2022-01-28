public class Principal {

    public static void main(String[] args) {
        // una clase abstracta no puede ser instanciada
//        Animal a = new Animal("animal 1");
//        a.comer();
//        a.dormir();
//        a.hacerRuido();

        Perro p = new Perro("LUCAS");
        p.pasear();
        p.comer();
        p.dormir();
        p.hacerRuido();

        Gato g = new Gato();
        g.trepar();
        g.comer();
        g.dormir();
        g.hacerRuido();


        // la clase abstracta no puede ser instanciada
        // Perro p = new Animal();

        // Ligadura dinámica - principio de sustitución de Liskov
        Animal a = new Perro("DROOPY");
        a.hacerRuido();
        // no se puede invocar un método que no haya sido definido en Animal
        // a.pasear();

        // bottom-up casting
        Object object = a;

        // top-down casting
        Perro perroConvertido = (Perro) a;
        perroConvertido.pasear();

        Animal b = new Gato();
        b.hacerRuido();
        // no se puede invocar
        // b.trepar();

        //top-down casting
        Gato gatoConvertido = (Gato) b;
        gatoConvertido.trepar();

        Object r1 = new Gato();
        Gato objetoAGato = (Gato) r1;
        objetoAGato.trepar();

        System.out.println(r1 instanceof Animal);
        System.out.println(r1 instanceof Perro);
        System.out.println(r1 instanceof Gato);


        // ligadura dinámica
        Animal h = new Humano("Felipe");
        h.hacerRuido();

        // ligadura dinámica
        Volable v = new Ave("Pájaro");

        Volable humanoV = new Humano("cualquier gato");

        // casting de Volable a Animal
        Animal animalVolable = (Animal) v;

        Ave aveConcreta = new Ave("Pájaro 2");





    }
}
