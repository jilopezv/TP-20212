public class Contador {

    // algoritmo para mostrar los números del 1 al 10
    public static void main(String[] args) {
        int valor = 1;

        while (valor <= 10) {
            System.out.println(valor++);
        }

        do {
            System.out.println(valor);
        } while (valor <= 10);


        for (valor = 1; valor <= 10; valor++) {
            System.out.println(valor);
        }

        for (; ; ) {
            System.out.println("infinito");
        }




    }
}
