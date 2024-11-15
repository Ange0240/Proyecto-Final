
package CELULAR;

public class Celular {
    private String modelo;
    private double precio;
    private String especificaciones;

    // Constructor
    public Celular(String modelo, double precio, String especificaciones) {
        this.modelo = modelo;
        this.precio = precio;
        this.especificaciones = especificaciones;
    }

    // Getters y Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    // Método toString para representar al celular como un texto
    @Override
    public String toString() {
        return modelo + " - $" + precio;
    }
}