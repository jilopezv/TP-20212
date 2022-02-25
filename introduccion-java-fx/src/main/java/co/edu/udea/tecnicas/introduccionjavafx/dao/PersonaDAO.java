package co.edu.udea.tecnicas.introduccionjavafx.dao;

import co.edu.udea.tecnicas.introduccionjavafx.dao.exception.DatosRepetidosException;
import co.edu.udea.tecnicas.introduccionjavafx.model.Persona;

import java.util.List;

public interface PersonaDAO {

    void guardarPersona(Persona persona) throws DatosRepetidosException;

    List<Persona> consultarPersonas();

}
