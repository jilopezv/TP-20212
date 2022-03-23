package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.bsn.DireccionBsn;
import co.edu.udea.tecnicas.ejemploborderpane.bsn.UsuarioBsn;
import co.edu.udea.tecnicas.ejemploborderpane.model.Direccion;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;

public class AgregarDireccionController {

    @FXML
    private ComboBox<Usuario> cmbUsuarios;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtValor;


    private UsuarioBsn usuarioBsn;
    private DireccionBsn direccionBsn;

    public AgregarDireccionController(){
        this.usuarioBsn = new UsuarioBsn();
        this.direccionBsn = new DireccionBsn();
    }

    @FXML
    private void initialize(){
        List<Usuario> usuarios = this.usuarioBsn.listarUsuarios();
        ObservableList<Usuario> usuariosObservables = FXCollections.observableList(usuarios);
        this.cmbUsuarios.setItems(usuariosObservables);
    }

    public void cmdLimpiarCampos_action(){

    }

    public void cmdAgregar_action(){
        Usuario usuarioSeleccionado = this.cmbUsuarios.getValue();
        String nombre = txtNombre.getText();
        String valor = txtValor.getText();

        Direccion direccion = new Direccion(nombre, valor);
        direccion.setUsuario(usuarioSeleccionado);
        this.direccionBsn.registrarDireccion(direccion);
    }
}
