package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.bsn.UsuarioBsn;
import co.edu.udea.tecnicas.ejemploborderpane.bsn.exception.UsuarioYaExisteException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

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

    private UsuarioBsn usuarioBsn;

    public AgregarUsuarioController() {
        this.usuarioBsn = new UsuarioBsn();
    }

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

        cargarListaUsuarios();
    }

    private void cargarListaUsuarios() {
        List<Usuario> usuariosList = this.usuarioBsn.listarUsuarios();
        ObservableList<Usuario> usuariosObservablesList = FXCollections.observableList(usuariosList);
        tblUsuarios.setItems(usuariosObservablesList);
    }


    public void cmdAgregar_action() {
        String idIngresado = txtIdentificacion.getText();
        String nombresIngresados = txtNombres.getText();
        String apellidosIngresados = txtApellidos.getText();
        String correoIngresado = txtCorreo.getText();

        boolean esValido = validarFormulario(idIngresado, nombresIngresados, apellidosIngresados, correoIngresado);

        if (esValido) {
            Integer idEntero = Integer.parseInt(idIngresado);
            Usuario usuario = new Usuario(idEntero, nombresIngresados, apellidosIngresados, correoIngresado);
            try {
                this.usuarioBsn.registrarUsuario(usuario);
            } catch (UsuarioYaExisteException uyee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Resultado transacción");
                alert.setHeaderText("Registrar usuario");
                alert.setContentText(uyee.getMessage());
                alert.showAndWait();
                txtIdentificacion.requestFocus();
                return;
            }
            this.tblUsuarios.getItems().add(usuario);
            // this.tblUsuarios.refresh();
            // this.cargarListaUsuarios();
            this.limpiarCampos();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Resultado transacción");
            alert.setHeaderText("Registrar usuario");
            alert.setContentText("El usuario se ha registrado correctamente");
            alert.showAndWait();
            txtIdentificacion.requestFocus();
        }


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

    }

    private boolean validarFormulario(String idIngresado, String nombresIngresados, String apellidosIngresados, String correoIngresado) {
        if (idIngresado.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Identificación");
            alert.setContentText("La identificación es requerida");
            alert.showAndWait();
            txtIdentificacion.requestFocus();
            return false;
        }

        if (nombresIngresados.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nombres");
            alert.setContentText("Los nombres son requeridos");
            alert.showAndWait();
            txtNombres.requestFocus();
            return false;
        }

        if (apellidosIngresados.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Apellidos");
            alert.setContentText("Los apellidos son requeridos");
            alert.showAndWait();
            txtApellidos.requestFocus();
            return false;
        }

        if (correoIngresado.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Correo electrónico");
            alert.setContentText("El correo electrónico es requerido");
            alert.showAndWait();
            txtCorreo.requestFocus();
            return false;
        }

        // se valida el formato del  correo electrónico
        if (!correoIngresado.matches("^(.+)@(.+)$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Correo electrónico");
            alert.setContentText("Ha ingresado un correo electrónico inválido");
            alert.showAndWait();
            txtCorreo.requestFocus();
            return false;
        }
        return true;
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
