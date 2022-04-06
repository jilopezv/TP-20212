package co.edu.udea.tecnicas.ejemploborderpane.dao.impl;

import co.edu.udea.tecnicas.ejemploborderpane.dao.DireccionDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.UsuarioDAO;
import co.edu.udea.tecnicas.ejemploborderpane.dao.exception.RegistroDuplicadoException;
import co.edu.udea.tecnicas.ejemploborderpane.model.Direccion;
import co.edu.udea.tecnicas.ejemploborderpane.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAOFile implements DireccionDAO {

    private File direccionesBD;

    private UsuarioDAO usuarioDAO;

    public DireccionDAOFile() {
        usuarioDAO = new UsuarioDAOFile();
        direccionesBD = new File("direcciones");
        if (!direccionesBD.exists()) {
            try {
                direccionesBD.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }


    @Override
    public void registrarDireccion(Direccion direccion) throws RegistroDuplicadoException {
        if (consultarDireccionPorIdUsuarioYNombreDireccion(direccion.getUsuario().getIdentificacion(), direccion.getNombre()) != null) {
            throw new RegistroDuplicadoException();
        }
        String direccionString = String.format("%d;%s;%s\n", direccion.getUsuario().getIdentificacion(), direccion.getNombre(), direccion.getValor());
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(direccionesBD, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(direccionString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Direccion> listarDireccionesPorUsuario(Integer identificacionUsuario) {
        List<Direccion> direcciones = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(direccionesBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Direccion direccion = parseDireccionFromString(registro);
                if (direccion.getUsuario().getIdentificacion().equals(identificacionUsuario)) {
                    direcciones.add(direccion);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return direcciones;
    }

    @Override
    public Direccion consultarDireccionPorIdUsuarioYNombreDireccion(Integer idUsuario, String nombreDireccion) {
        try {
            FileReader fileReader = new FileReader(direccionesBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Direccion direccion = parseDireccionFromString(registro);
                if (direccion.getUsuario().getIdentificacion().equals(idUsuario) && direccion.getNombre().equals(nombreDireccion)) {
                    return direccion;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Direccion> consultarDireccionesUsuario(Integer idUsuario) {
        try {
            FileReader fileReader = new FileReader(direccionesBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String registro;
            List<Direccion> direccionesUsuario = new ArrayList<>();
            while ((registro = bufferedReader.readLine()) != null) {
                Direccion direccion = parseDireccionFromString(registro);
                if (direccion.getUsuario().getIdentificacion().equals(idUsuario)) {
                    direccionesUsuario.add(direccion);
                }
            }
            bufferedReader.close();
            return direccionesUsuario;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Direccion parseDireccionFromString(String registro) {
        String[] partes = registro.split(";");
        Usuario usuario = this.usuarioDAO.consultarUsuarioPorId(Integer.parseInt(partes[0]));
        Direccion direccion = new Direccion(partes[1], partes[2]);
        direccion.setUsuario(usuario);
        return direccion;
    }
}
