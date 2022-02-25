package co.edu.udea.tecnicas.introduccionjavafx.bsn.exception;

public class PersonaYaExisteException extends Exception{

    public PersonaYaExisteException(){
        super("La persona ya está registrada");
    }
}
