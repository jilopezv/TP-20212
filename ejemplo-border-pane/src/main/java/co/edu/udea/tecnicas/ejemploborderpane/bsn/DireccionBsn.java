package co.edu.udea.tecnicas.ejemploborderpane.bsn;

import co.edu.udea.tecnicas.ejemploborderpane.dao.DireccionDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.dao.impl.DireccionDAOFile;
import co.edu.udea.tecnicas.ejemploborderpane.model.Direccion;

import java.util.List;

public class DireccionBsn {
    private DireccionDAO direccionDAO;

    public DireccionBsn(){
        this.direccionDAO = new DireccionDAOFile();
    }

    public void registrarDireccion(Direccion direccion){
        try {
            this.direccionDAO.registrarDireccion(direccion);
        }catch (RegistroDuplicadoException rde){
            rde.printStackTrace();
        }
    }

    public List<Direccion> consultarDirecciones(Integer identificacion) {
        return direccionDAO.consultarDireccionesUsuario(identificacion);
    }
}
