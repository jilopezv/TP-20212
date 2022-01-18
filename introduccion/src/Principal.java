import test.EPS;
import test.Empleado;

public class Principal {

    public static void main(String[] args) {
        // declaración de variables de tipos de datos primitivos
        int a;
        double b;
        char c;

        // asignación de valores a un tipo de dato primitivo
        a = 5;
        b = 3.3;
        c = ' ';


        // declaración de variables de tipos de datos personalizados
        Empleado e = new Empleado("123", "Empleado", "1", "Programador");

        e.setSalario(2_000_000);
        // e.eps = "La peor eps";

        Empleado e2 = new Empleado();
        System.out.println(e.getEps());
        System.out.println(e.getNombres());


    }
}
