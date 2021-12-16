package test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrincipalEmpleados {

    private static List<EPS> listaEPS = new ArrayList();

    public static void main(String[] args) {
        String opcion = "";
        String menu = "Bienvenido. Seleccione una opción:\n" +
                "1. Crear EPS.\n" +
                "2. Ver listado EPS\n" +
                "3. Salir";
        do {
            opcion = JOptionPane.showInputDialog(menu);
            switch (opcion){
                case "1":
                    String nitEPS = JOptionPane.showInputDialog("Ingrese el nit de la EPS:");
                    String nombreEPS = JOptionPane.showInputDialog("Ingrese el nombre de la EPS:");

                    // TODO: validar los valores ingresados
                    EPS eps = new EPS(nitEPS, nombreEPS);
                    listaEPS.add(eps);

                    JOptionPane.showMessageDialog(null, "La EPS se ha creado correctamente.");
                    break;
                case "2":
                    for(EPS epsEnLista: listaEPS){
                        JOptionPane.showMessageDialog(null, epsEnLista);
                    }
                    break;
                default:
                    break;
            }

        } while (!opcion.equals("3"));


    }
}
