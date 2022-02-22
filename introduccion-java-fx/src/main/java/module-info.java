module co.edu.udea.tecnicas.introduccionjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens co.edu.udea.tecnicas.introduccionjavafx to javafx.fxml;
    exports co.edu.udea.tecnicas.introduccionjavafx;
    exports co.edu.udea.tecnicas.introduccionjavafx.controller;
    opens co.edu.udea.tecnicas.introduccionjavafx.controller to javafx.fxml;
}