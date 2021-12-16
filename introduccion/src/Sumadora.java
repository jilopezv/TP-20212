import javax.swing.JOptionPane;

public class Sumadora {


    // algoritmo para sumar dos números enteros que ingresa el usuario
    public static void main(String[] args) {
        int num1, num2, resultado;

        String num1String = JOptionPane.showInputDialog("Ingrese el primer número:");
        String num2String = JOptionPane.showInputDialog("Ingrese el segundo número:");

        num1 = Integer.parseInt(num1String);
        num2 = Integer.parseInt(num2String);

        resultado = num1 + num2;

        JOptionPane.showMessageDialog(null, "El resultado es " + resultado);

        if (resultado % 2 == 0) {
            JOptionPane.showMessageDialog(null, "El número " + resultado + " es par");
        } else {
            JOptionPane.showMessageDialog(null, "El número " + resultado + " es impar");
        }

        if (resultado < 0) {
            JOptionPane.showMessageDialog(null, "El número " + resultado + " es negativo");
        } else {
            JOptionPane.showMessageDialog(null, "El número " + resultado + " es positivo");
        }

    }
}
