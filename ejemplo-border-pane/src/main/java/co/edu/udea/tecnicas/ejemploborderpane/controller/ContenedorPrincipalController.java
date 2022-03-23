package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.EjemploBorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ContenedorPrincipalController {

    @FXML
    private BorderPane contenedorPrincipal;

    public void mnuCerrar_action() {
        System.exit(0);
    }

    public void mnuAgregarUsuario_action() throws IOException {
        AnchorPane agregarRegistro = FXMLLoader.load(EjemploBorderPane.class.getResource("view/agregar-usuario.fxml"));
        contenedorPrincipal.setCenter(agregarRegistro);
    }

    public void mnuAgregarDireccion_action() throws IOException {
        AnchorPane agregarRegistro = FXMLLoader.load(EjemploBorderPane.class.getResource("view/agregar-direccion.fxml"));
        contenedorPrincipal.setCenter(agregarRegistro);
    }


    public void mnuEliminarRegistro_action() throws IOException {
        AnchorPane eliminarRegistro = FXMLLoader.load(EjemploBorderPane.class.getResource("view/eliminar-registro.fxml"));
        contenedorPrincipal.setCenter(eliminarRegistro);
    }


}