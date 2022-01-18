package test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la aplicación.
 * contiene toda la lógica para la gestión de eps y empleados.
 */
public class PrincipalEmpleados {

    private static List<EPS> listaEPS = new ArrayList();
    private static List<Empleado> listaEmpleados = new ArrayList();


    public static void main(String[] args) {
        String opcion = "";
        String menu = "Bienvenido. Seleccione una opción:\n" +
                "1. Crear EPS.\n" +
                "2. Ver listado EPS.\n" +
                "3. Agregar empleado.\n" +
                "4. Consultar empleado.\n" +
                "5. Salir.";
        do {
            opcion = JOptionPane.showInputDialog(menu);
            switch (opcion) {
                case "1":
                    String nitEPS = JOptionPane.showInputDialog("Ingrese el nit de la EPS:");
                    String nombreEPS = JOptionPane.showInputDialog("Ingrese el nombre de la EPS:");

                    // TODO: validar los valores ingresados
                    EPS eps = new EPS(nitEPS, nombreEPS);
                    listaEPS.add(eps);

                    JOptionPane.showMessageDialog(null, "La EPS se ha creado correctamente.");
                    break;
                case "2":
                    // if (listaEPS.size()==0)
                    if (listaEPS.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se ha agregado ninguna EPS aún");
                    } else {
                        //for-each en Java
                        for (EPS epsEnLista : listaEPS) {
                            JOptionPane.showMessageDialog(null, epsEnLista);
                        }
                    }
                    break;
                case "3":
                    String idEmpleado = JOptionPane.showInputDialog("Ingrese el id del empleado:");
                    String nombresEmpleado = JOptionPane.showInputDialog("Ingrese los nombres del empleado:");
                    String apellidosEmpleado = JOptionPane.showInputDialog("Ingrese los apellidos del empleado:");
                    String cargoEmpleado = JOptionPane.showInputDialog("Ingrese el cargo del empleado:");

                    // se busca la eps por nit para asignarla al empleado
                    String nitEpsEmpleado = JOptionPane.showInputDialog("Ingrese el nit de la eps:");
                    EPS epsBusqueda = null;
                    boolean epsEncontrada = false;
                    for (int i = 0; i < listaEPS.size(); i++) {
                        epsBusqueda = listaEPS.get(i);
                        if (epsBusqueda.getNit().equals(nitEpsEmpleado)) {
                            System.out.println("EPS encontrada en la posición: " + i);
                            JOptionPane.showMessageDialog(null, epsBusqueda);
                            epsEncontrada = true;
                            break;
                        }
                    }
                    if (!epsEncontrada) {
                        JOptionPane.showMessageDialog(null, "La eps no se encuentra registrada: "+nitEpsEmpleado);
                        break;
                    }

                    //TODO validar los datos ingresados
                    Empleado empleado = new Empleado(idEmpleado, nombresEmpleado, apellidosEmpleado, cargoEmpleado);
                    empleado.setEps(epsBusqueda);
                    listaEmpleados.add(empleado);
                    epsBusqueda.afiliarEmpleado(empleado);
                    break;
                case "4":
                    String idABuscar = JOptionPane.showInputDialog("Ingrese el id del empleado a consultar:");
                    boolean encontrado = false;
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        Empleado emp = listaEmpleados.get(i);
                        if (emp.getId().equals(idABuscar)) {
                            System.out.println("Empleado encontrado en la posición: " + i);
                            JOptionPane.showMessageDialog(null, emp);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado a un empleado con id: " + idABuscar);
                    }
                    break;
                default:
                    break;
            }

        } while (!opcion.equals("5"));


    }
}
