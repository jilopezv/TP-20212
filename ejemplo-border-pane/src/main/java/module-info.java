module co.edu.udea.tecnicas.ejemploborderpane {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens co.edu.udea.tecnicas.ejemploborderpane to javafx.fxml;
    exports co.edu.udea.tecnicas.ejemploborderpane;
    exports co.edu.udea.tecnicas.ejemploborderpane.controller;
    opens co.edu.udea.tecnicas.ejemploborderpane.controller to javafx.fxml;
}