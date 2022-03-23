package co.edu.udea.tecnicas.ejemploborderpane.dao;

import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Direccion;

import java.util.List;

public interface DireccionDAO {

    void registrarDireccion(Direccion direccion) throws RegistroDuplicadoException;

    List<Direccion> listarDireccionesPorUsuario(Integer identificacionUsuario);

    Direccion consultarDireccionPorIdUsuarioYNombreDireccion(Integer idUsuario, String nombreDireccion);

}
