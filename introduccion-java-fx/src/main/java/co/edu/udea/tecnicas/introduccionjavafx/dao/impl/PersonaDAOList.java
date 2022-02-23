package co.edu.udea.tecnicas.introduccionjavafx.dao.impl;

import co.edu.udea.tecnicas.introduccionjavafx.dao.PersonaDAO;
import co.edu.udea.tecnicas.introduccionjavafx.dao.exception.DatosRepetidosException;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAOList implements PersonaDAO {

    private static final List<Integer> personas = new ArrayList<>();

    @Override
    public void guardarPersona(Integer id) throws DatosRepetidosException {
        if (consultarPersonaPorId(id)) {
            throw new DatosRepetidosException();
        }
        personas.add(id);
    }

    @Override
    public List<Integer> consultarPersonas() {
        // TODO retornar una copia
        return personas;
    }

    public boolean consultarPersonaPorId(Integer id) {
        for (Integer persona : personas) {
            if (persona.equals(id)) {
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
