package co.edu.udea.tecnicas.ejemploborderpane.dao;

import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void registrarUsuario(Usuario usuario) throws RegistroDuplicadoException;

    List<Usuario> listarUsuarios();

    Usuario consultarUsuarioPorId(Integer id);
}
