package co.edu.udea.tecnicas.ejemploborderpane.controller;

import co.edu.udea.tecnicas.ejemploborderpane.model.Imagen;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class VisualizadorImagenesController {

    @FXML
    private TableView<Imagen> tblImagenes;
    @FXML
    private TableColumn<Imagen, String> clmNombre;
    @FXML
    private TableColumn<Imagen, String> clmRuta;
    @FXML
    private ImageView imgImagenSeleccionada;

    @FXML
    private void initialize() {
        this.clmNombre.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getNombre()));
        this.clmRuta.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getRuta()));
        // este método va a ser el encargado de escuchar cuando se seleccione una fila de la tabla
        tblImagenes.getSelectionModel().selectedItemProperty().addListener(((observableValue, imagenPrevia, imagenNueva) -> tblImagenesItemSeleccionado_listener(imagenNueva)));
    }

    public void cmdAgregarImagen_action() throws IOException {
        FileChooser fileChooser = new FileChooser();
        // Se configuran los tipos de archivo soportados
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG files", "*.png")
                , new FileChooser.ExtensionFilter("JPG Files", "*.jpg")
                , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
        );
        // se muestra el selector de archivos en la misma escena en la que están los componentes
        File archivoSeleccionado = fileChooser.showOpenDialog(this.tblImagenes.getScene().getWindow());
        //si no se seleccionada nada, se termina el método
        if (archivoSeleccionado == null) {
            return;
        }
        // se copia la imagen desde el archivo seleccionado a la carpeta de destino denominada imagenes; si la imagen ya existe, se reemplaza
        Path rutaDestino = Files.copy(archivoSeleccionado.toPath(), Path.of("imagenes", archivoSeleccionado.getName()), StandardCopyOption.REPLACE_EXISTING);
        // Se crea una instancia de la clase del modelo Imagen para agregarla a la tabla de imágenes
        Imagen imagenCargada = new Imagen(rutaDestino.getFileName().toString(), rutaDestino.toFile().getAbsolutePath());
        // se agrega en la posición 0 para que siempre queden en la primera posición las últimas imágenes cargadas
        tblImagenes.getItems().add(0, imagenCargada);
        // se selecciona la última imagen carga para que se dispare el evento de la tabla denominado: tblImagenesItemSeleccionado_listener y forzar a que esta sea pintada en el ImageView
        this.tblImagenes.getSelectionModel().select(0);
    }

    private void tblImagenesItemSeleccionado_listener(Imagen imagenNueva) {
        try {
            //se crea una imagen a partir de la ruta del archivo de imagen
            InputStream stream = new FileInputStream(imagenNueva.getRuta());
            Image image = new Image(stream);
            //Se asigna la imagen cargada al objeto ImageView
            imgImagenSeleccionada.setImage(image);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            imgImagenSeleccionada.setImage(null);
        }
    }
}
