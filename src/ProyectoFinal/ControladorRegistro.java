
package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class ControladorRegistro {
    private List<Usuario> listaUsuarios;

    public ControladorRegistro() {
        listaUsuarios = new ArrayList<>();
    }

    // Método para registrar un usuario
    public void registrarUsuario(String nombre, String nroIdentificacion, String contraseña, String tipoUsuario) {
        Usuario nuevoUsuario = new Usuario(nombre, nroIdentificacion, contraseña, tipoUsuario);
        listaUsuarios.add(nuevoUsuario);
    }

    // Obtener la lista de usuarios
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}