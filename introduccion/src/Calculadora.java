import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        double num1, num2, resultado = 0.0;
        char operacion;

        do {

            operacion = JOptionPane.showInputDialog("Ingrese la operación: [ + - * / ] (& para terminar): ").charAt(0);

            if (operacion == '&') {
                JOptionPane.showMessageDialog(null, "Hasta luego!");
                continue;
            }

            num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
            num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));

            if (operacion == '+') {
                resultado = num1 + num2;
            } else if (operacion == '-') {
                resultado = num1 - num2;
            } else if (operacion == '*') {
                resultado = num1 * num2;
            } else if (operacion == '/') {
                resultado = num1 / num2;
            } else {
                JOptionPane.showMessageDialog(null, "Operación incorrecta");
                continue;
            }

            JOptionPane.showMessageDialog(null, String.format("El resultado de %f %c %f es %f ", num1, operacion, num2, resultado ));
        } while (operacion != '&');

    }
}
