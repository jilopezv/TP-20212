package co.edu.udea.tecnicas.introduccionjavafx.dao;

import co.edu.udea.tecnicas.introduccionjavafx.dao.exception.DatosRepetidosException;

import java.util.List;

public interface PersonaDAO {

    void guardarPersona(Integer id) throws DatosRepetidosException;

    List<Integer> consultarPersonas();

}
