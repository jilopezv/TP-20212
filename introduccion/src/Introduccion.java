import test.Empleado;

public class Introduccion {

    /*
        ESTE ES UN
        COMENTARIO
        MULTILÍNEA
     */
    //ESTE ES UN COMENTARIO DE UNA SOLA LÍNEA
    public static void main(String[] args) {
        byte edad = 127; // se crea una variable de tipo byte para la edad
        int id = 12345678;
        String nombre = "aaaaaaAAA";

        char a = 'é';

        System.out.println(edad + 10);

        System.out.println(nombre);

        System.out.println(edad > 10);

        System.out.println(edad <= 23 && id == 123);

        System.out.println(edad * 1000);

        System.out.println();

        edad += 1;
        System.out.println(edad);

        Empleado e = new Empleado();


    }

}
