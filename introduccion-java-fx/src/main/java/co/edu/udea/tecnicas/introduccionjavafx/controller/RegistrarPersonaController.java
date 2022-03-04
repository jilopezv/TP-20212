package co.edu.udea.tecnicas.introduccionjavafx.controller;

import co.edu.udea.tecnicas.introduccionjavafx.HelloApplication;
import co.edu.udea.tecnicas.introduccionjavafx.bsn.PersonaBsn;
import co.edu.udea.tecnicas.introduccionjavafx.bsn.exception.PersonaYaExisteException;
import co.edu.udea.tecnicas.introduccionjavafx.model.Persona;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarPersonaController {

    @FXML
    private VBox vboxPrincipal;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombres;

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
            Integer idIngresado = Integer.parseInt(txtIdentificacion.getText());
            String nombresIngresados = txtNombres.getText();

            Persona personaNueva = new Persona(idIngresado, nombresIngresados);

            personaBsn.guardarPersona(personaNueva);
            lblResultado.setText("Transacción realizada correctamente");
            // txtIdentificacion.setText("");
        } catch (NumberFormatException nfe) {
            System.out.println("Excepción controlada");
            lblResultado.setText("¡Sólo números por favor!");
        } catch (PersonaYaExisteException e) {
            System.out.println("Excepción controlada");
            lblResultado.setText(e.getMessage());
        } finally {
            txtIdentificacion.clear();
            txtNombres.clear();
        }

    }

    public void cmdIrAVisualizacion_action() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/listar-personas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        Stage stage = (Stage) this.txtIdentificacion.getScene().getWindow();

        stage.setTitle("Listado de personas registradas");
        stage.setScene(scene);
        // stage.show();

        /*
        List<Persona> personas = personaBsn.consultarPersonas();
        personas.forEach(System.out::println);

            for(int i=0; i<personas.size(); i++){
                System.out.println(personas.get(i));
            }
         */
    }
}