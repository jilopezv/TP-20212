package co.edu.udea.tecnicas.introduccionjavafx.controller;

import co.edu.udea.tecnicas.introduccionjavafx.bsn.PersonaBsn;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class RegistrarPersonaController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private Label lblResultado;

    private PersonaBsn personaBsn;

    public RegistrarPersonaController() {
        System.out.println("Se instancia la clase HelloController");
        personaBsn = new PersonaBsn();
    }

    @FXML
    public void initialize() {
        lblResultado.setText("Ya todo fue creado");
    }


    public void cmdGuardar_action() {
        try {
            Integer edadIngresada = Integer.parseInt(txtIdentificacion.getText());
            personaBsn.guardarPersona(edadIngresada);
            lblResultado.setText("Transacción realizada correctamente");
            // txtIdentificacion.setText("");
            txtIdentificacion.clear();
        } catch (NumberFormatException nfe) {
            System.out.println("Excepción controlada");
            nfe.printStackTrace();
            lblResultado.setText("¡Sólo números por favor!");
        }
    }

    public void cmdImprimirDatos_action() {
        List<Integer> personas = personaBsn.consultarPersonas();
        personas.forEach(System.out::println);
        /*
            for(int i=0; i<personas.size(); i++){
                System.out.println(personas.get(i));
            }
         */
    }
}