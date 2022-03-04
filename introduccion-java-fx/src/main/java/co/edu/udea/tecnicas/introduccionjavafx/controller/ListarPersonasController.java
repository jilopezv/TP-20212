package co.edu.udea.tecnicas.introduccionjavafx.controller;

import co.edu.udea.tecnicas.introduccionjavafx.HelloApplication;
import co.edu.udea.tecnicas.introduccionjavafx.bsn.PersonaBsn;
import co.edu.udea.tecnicas.introduccionjavafx.model.Persona;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListarPersonasController {

    @FXML
    private VBox vboxPrincipal;

    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn<Persona, Integer> clmIdentificacion;
    @FXML
    private TableColumn<Persona, String> clmNombres;

    private PersonaBsn personaBsn;

    public ListarPersonasController(){
        this.personaBsn = new PersonaBsn();
    }

    @FXML
    public void initialize(){
        // se consultan todas las personas almacenadas
        List<Persona> personas = this.personaBsn.consultarPersonas();
        // se crea una lista observable para hacer binding con la tabla
        ObservableList<Persona> personasObservables = FXCollections.observableList(personas);
        // se asigna la lista observable a la tabla
        tblPersonas.setItems(personasObservables);
        // se especifican los métodos a invocar para obtener los valores a mostrar en las celdas
        clmIdentificacion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        clmNombres.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombres()));

    }


    public void cmdRegresar_action() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/registrar-persona.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        Stage stage = (Stage)this.vboxPrincipal.getScene().getWindow(); //new Stage();

        stage.setTitle("Registrar persona");
        stage.setScene(scene);
        stage.show();
    }
}
