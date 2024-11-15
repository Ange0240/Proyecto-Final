
package TELEVISORES;

import java.util.ArrayList;
import java.util.List;

public class ControladorTelevisores {

    private List<Televisores> listaTelevisores;

    // Constructor
    public ControladorTelevisores() {
        this.listaTelevisores = new ArrayList<>();
        // Cargar algunos televisores por defecto (si lo necesitas)
        cargarTelevisoresPorDefecto();
    }

    // Método para obtener la lista de televisores
    public List<Televisores> getListaTelevisores() {
        return listaTelevisores;
    }
    
    public Televisores getTelevisorPorModelo(String modelo) {
    for (Televisores televisor : listaTelevisores) {
        if (televisor.getModelo().equals(modelo)) {
            return televisor;
        }
    }
    return null; // Si no se encuentra el televisor
}
    
    // Método para agregar un televisor a la lista
    public void agregarTelevisor(Televisores televisor) {
        listaTelevisores.add(televisor);
    }

    // Método para cargar algunos televisores de ejemplo
    private void cargarTelevisoresPorDefecto() {
        listaTelevisores.add(new Televisores("Samsung QLED 55\"", 899.99, "Resolución 4K Full HD - 120Hz"));
        listaTelevisores.add(new Televisores("LG OLED 65\"", 1799.99, "Resolución 4K - 120Hz Fuerte rendimiento"));
        listaTelevisores.add(new Televisores("Sony Bravia 50\"", 699.99, "Resolución 1080p - 60Hz"));
    }
}
