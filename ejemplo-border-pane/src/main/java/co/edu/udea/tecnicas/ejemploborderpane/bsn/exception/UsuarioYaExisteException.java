package co.edu.udea.tecnicas.ejemploborderpane.bsn.exception;

public class UsuarioYaExisteException extends Exception {

    public UsuarioYaExisteException() {
        super("El usuario que desea almacenar ya existe");
    }
}
