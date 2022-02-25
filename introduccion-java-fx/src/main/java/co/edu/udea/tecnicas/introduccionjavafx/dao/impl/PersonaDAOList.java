package co.edu.udea.tecnicas.introduccionjavafx.dao.impl;

import co.edu.udea.tecnicas.introduccionjavafx.dao.PersonaDAO;
import co.edu.udea.tecnicas.introduccionjavafx.dao.exception.DatosRepetidosException;
import co.edu.udea.tecnicas.introduccionjavafx.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAOList implements PersonaDAO {

    private static final List<Persona> personas = new ArrayList<>();

    @Override
    public void guardarPersona(Persona persona) throws DatosRepetidosException {
        if (consultarPersonaPorId(persona.getId())) {
            throw new DatosRepetidosException();
        }
        personas.add(persona);
    }

    @Override
    public List<Persona> consultarPersonas() {
        // TODO retornar una copia
        return personas;
    }

    public boolean consultarPersonaPorId(Integer id) {
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                return true;
            }
        }
        return false;

        /*
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).equals(id)) {
                return true;
            }
        }
         */
    }
}
