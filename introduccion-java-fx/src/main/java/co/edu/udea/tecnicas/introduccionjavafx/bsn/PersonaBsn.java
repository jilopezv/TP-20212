package co.edu.udea.tecnicas.introduccionjavafx.bsn;

import co.edu.udea.tecnicas.introduccionjavafx.dao.PersonaDAO;
import co.edu.udea.tecnicas.introduccionjavafx.dao.exception.DatosRepetidosException;
import co.edu.udea.tecnicas.introduccionjavafx.dao.impl.PersonaDAOList;

import java.util.List;

public class PersonaBsn {

    private PersonaDAO personaDAO;

    public PersonaBsn() {
        this.personaDAO = new PersonaDAOList();
    }

    public void guardarPersona(Integer id) {
        // TODO lógica de negocio
        try {
            this.personaDAO.guardarPersona(id);
        } catch (DatosRepetidosException dre) {
            System.out.println("Excepción capturada en el negocio desde el DAO");
        }
    }

    public List<Integer> consultarPersonas() {
        // TODO lógica de negocio
        return this.personaDAO.consultarPersonas();
    }

    public Integer calcularAnioNacimiento(Integer edad) {
        return 2022 - edad;
    }


}
