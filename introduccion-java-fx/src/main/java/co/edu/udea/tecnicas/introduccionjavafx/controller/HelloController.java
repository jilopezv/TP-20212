package co.edu.udea.tecnicas.introduccionjavafx.controller;

import co.edu.udea.tecnicas.introduccionjavafx.bsn.PersonaBsn;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private Label lblResultado;

    private PersonaBsn personaBsn;

    public HelloController(){
        System.out.println("Se instancia la clase HelloController");
        personaBsn = new PersonaBsn();
    }

    @FXML
    public void initialize(){
        lblResultado.setText("Ya todo fue creado");
    }


    public void cmdGuardar_action(){
        Integer edadIngresada = Integer.parseInt(txtIdentificacion.getText());
        Integer anio = personaBsn.calcularAnioNacimiento(edadIngresada);
        lblResultado.setText(anio.toString());
    }
}