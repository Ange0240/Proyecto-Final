
package ProyectoFinal;

public class Usuario {
    private String nombre;
    private String nroIdentificacion;
    private String contraseña;
    private String tipoUsuario;

    public Usuario(String nombre, String nroIdentificacion, String contraseña, String tipoUsuario) {
        this.nombre = nombre;
        this.nroIdentificacion = nroIdentificacion;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}