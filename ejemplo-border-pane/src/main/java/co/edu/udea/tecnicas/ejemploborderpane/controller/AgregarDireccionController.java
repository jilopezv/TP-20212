package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.bsn.DireccionBsn;
import co.edu.udea.tecnicas.ejemploborderpane.bsn.UsuarioBsn;
import co.edu.udea.tecnicas.ejemploborderpane.model.Direccion;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class AgregarDireccionController {

    @FXML
    private ComboBox<Usuario> cmbUsuarios;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtValor;
    @FXML
    private TableView<Direccion> tblUsuarios;
    @FXML
    private TableColumn<Direccion, String> clmNombre;
    @FXML
    private TableColumn<Direccion, String> clmValor;


    private UsuarioBsn usuarioBsn;
    private DireccionBsn direccionBsn;

    public AgregarDireccionController() {
        this.usuarioBsn = new UsuarioBsn();
        this.direccionBsn = new DireccionBsn();
    }

    @FXML
    private void initialize() {
        List<Usuario> usuarios = this.usuarioBsn.listarUsuarios();
        ObservableList<Usuario> usuariosObservables = FXCollections.observableList(usuarios);
        this.cmbUsuarios.setItems(usuariosObservables);
        this.cmbUsuarios.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, usuarioPrevio, usuarioNuevo) -> cmbUsuariosItemSeleccionado_listener(usuarioNuevo)
        );
        this.clmNombre.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getNombre()));
        this.clmValor.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getValor()));

    }

    private void cmbUsuariosItemSeleccionado_listener(Usuario usuarioNuevo) {
        if (usuarioNuevo != null) {
            List<Direccion> direccionesUsuario = this.direccionBsn.consultarDirecciones(usuarioNuevo.getIdentificacion());
            ObservableList<Direccion> direccionesUsuarioObservables = FXCollections.observableList(direccionesUsuario);
            tblUsuarios.setItems(direccionesUsuarioObservables);
        }

    }

    public void cmdLimpiarCampos_action() {
        limpiarCampos();
    }

    public void cmdAgregar_action() {
        Usuario usuarioSeleccionado = this.cmbUsuarios.getValue();
        String nombre = txtNombre.getText();
        String valor = txtValor.getText();

        Direccion direccion = new Direccion(nombre, valor);
        direccion.setUsuario(usuarioSeleccionado);
        this.direccionBsn.registrarDireccion(direccion);
        this.tblUsuarios.getItems().add(direccion);
        limpiarCampos();
    }

    private void limpiarCampos(){
        this.txtNombre.clear();
        this.txtValor.clear();
    }
}
