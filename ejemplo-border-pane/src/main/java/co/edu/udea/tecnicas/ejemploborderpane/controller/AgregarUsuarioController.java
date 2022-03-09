package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AgregarUsuarioController {

    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TableView<Usuario> tblUsuarios;
    @FXML
    private TableColumn<Usuario, Integer> clmIdentificacion;
    @FXML
    private TableColumn<Usuario, String> clmNombres;

    @FXML
    private void initialize() {
        clmIdentificacion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdentificacion()).asObject());
        clmNombres.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombres()));

        txtIdentificacion.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^\\d+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));

        txtNombres.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^[\\p{L} .'-]+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));

        txtApellidos.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^[\\p{L} .'-]+$") || change.getControlNewText().isEmpty()) {
                return change;
            }
            return null;
        }));
    }


    public void cmdAgregar_action() {
        String idIngresado = txtIdentificacion.getText();
        String nombresIngresados = txtNombres.getText();
        String apellidosIngresados = txtApellidos.getText();
        String correoIngresado = txtCorreo.getText();

        //TODO validar campos obligatorios
        Integer idEntero = Integer.parseInt(idIngresado);

/*
        // se valida que la identificación sea un número
        try {
            idEntero = Integer.parseInt(idIngresado);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Identificación");
            alert.setContentText("Ha ingresado un número de identificación inválido");
            alert.showAndWait();
            txtIdentificacion.requestFocus();
            return;
        }
        */


        // se valida el correo electrónico
        if (!correoIngresado.matches("^(.+)@(.+)$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Correo electrónico");
            alert.setContentText("Ha ingresado un correo electrónico inválido");
            alert.showAndWait();
            txtCorreo.requestFocus();
            return;
        }

        Usuario usuario = new Usuario(idEntero, nombresIngresados, apellidosIngresados, correoIngresado);

        // todo llamar al negocio para almacenar el usuario
        this.tblUsuarios.getItems().add(usuario);
        this.limpiarCampos();


    }

    public void cmdLimpiarCampos_action() {
        this.limpiarCampos();
    }

    private void limpiarCampos() {
        txtIdentificacion.clear();
        txtNombres.clear();
        txtApellidos.clear();
        txtCorreo.clear();
    }


}
