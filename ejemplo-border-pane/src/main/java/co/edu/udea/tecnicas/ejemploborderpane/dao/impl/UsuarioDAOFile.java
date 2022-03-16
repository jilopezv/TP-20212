package co.edu.udea.tecnicas.ejemploborderpane.dao.impl;

import co.edu.udea.tecnicas.ejemploborderpane.dao.UsuarioDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOFile implements UsuarioDAO {

    private File usuariosBD;

    public UsuarioDAOFile() {
        usuariosBD = new File("usuarios");
        if (!usuariosBD.exists()) {
            try {
                usuariosBD.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws RegistroDuplicadoException {
        if (consultarUsuarioPorId(usuario.getIdentificacion()) != null) {
            throw new RegistroDuplicadoException();
        }
        // String usuarioString = usuario.getIdentificacion()+ ";"+usuario.getNombres()+";"+usuario.getApellidos()+";"+usuario.getCorreo()+"\n";
        String usuarioString = String.format("%d;%s;%s;%s\n", usuario.getIdentificacion(), usuario.getNombres(), usuario.getApellidos(), usuario.getCorreo());
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(usuariosBD, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(usuarioString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> resultado = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(usuariosBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Usuario usuario = parseUsuarioFromString(registro);
                resultado.add(usuario);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * Reconoce una cadena de caracteres que representa a un usuario y lo convierte en un Objeto de la clase
     * Usuario
     *
     * @param registro
     * @return
     */
    private Usuario parseUsuarioFromString(String registro) {
        // todo validar que el registro sí respete los campos requeridos de un objeto usuario
        String[] partes = registro.split(";");
        return new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3]);
    }

    @Override
    public Usuario consultarUsuarioPorId(Integer id) {
        try {
            FileReader fileReader = new FileReader(usuariosBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Usuario usuario = parseUsuarioFromString(registro);
                if (usuario.getIdentificacion().equals(id)) {
                    return usuario;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
