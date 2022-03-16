package co.edu.udea.tecnicas.ejemploborderpane.bsn;

import co.edu.udea.tecnicas.ejemploborderpane.bsn.exception.UsuarioYaExisteException;
import co.edu.udea.tecnicas.ejemploborderpane.dao.UsuarioDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.dao.impl.UsuarioDAOFile;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;

import java.util.List;

public class UsuarioBsn {
    private UsuarioDAO usuarioDAO;

    public UsuarioBsn() {
        this.usuarioDAO = new UsuarioDAOFile();
    }

    public void registrarUsuario(Usuario usuario) throws UsuarioYaExisteException {
        try {
            this.usuarioDAO.registrarUsuario(usuario);
        } catch (RegistroDuplicadoException e) {
            throw new UsuarioYaExisteException();
        }
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioDAO.listarUsuarios();
    }


}
