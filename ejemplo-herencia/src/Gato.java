public class Gato extends Animal{

    public void trepar(){
        System.out.println("Trepo como gato");
    }

    public void hacerRuido(){
        // invoco al método de la clase madre, el método base
        super.hacerRuido();
        System.out.print("... y, además, Maullo como gato");
    }
}
