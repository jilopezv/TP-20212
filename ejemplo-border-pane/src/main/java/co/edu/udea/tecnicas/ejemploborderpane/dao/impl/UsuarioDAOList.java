package co.edu.udea.tecnicas.ejemploborderpane.dao.impl;

import co.edu.udea.tecnicas.ejemploborderpane.dao.UsuarioDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOList implements UsuarioDAO {

    private final static List<Usuario> usuariosBD = new ArrayList<>();

    @Override
    public void registrarUsuario(Usuario usuario) throws RegistroDuplicadoException {
        if (consultarUsuarioPorId(usuario.getIdentificacion()) != null) {
            throw new RegistroDuplicadoException();
        }
        usuariosBD.add(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        // TODO retornar una copia, no la lista original
        return usuariosBD;
    }

    @Override
    public Usuario consultarUsuarioPorId(Integer id) {
        for (Usuario usuario : usuariosBD) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        // todo cambiar a Optional
        return null;
    }

}
