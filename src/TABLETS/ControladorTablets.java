
package TABLETS;
import ProyectoFinal.VistaTablets;

import java.util.ArrayList;
import java.util.List;

public class ControladorTablets {

    private List<Tablets> listaTablets;

    // Constructor
    public ControladorTablets() {
        this.listaTablets = new ArrayList<>();
        // Cargar algunas tablets por defecto (si lo necesitas)
        cargarTabletsPorDefecto();
    }

    // Método para obtener la lista de tablets
    public List<Tablets> getListaTablets() {
        return listaTablets;
    }

public Tablets getTabletPorModelo(String modelo) {
    for (Tablets tablet : listaTablets) {
        if (tablet.getModelo().equals(modelo)) {
            return tablet;
        }
    }
    return null; // Si no se encuentra la tablet
}

    
    // Método para agregar una tablet a la lista
    public void agregarTablet(Tablets tablet) {
        listaTablets.add(tablet);
    }

    // Método para cargar algunas tablets de ejemplo
    private void cargarTabletsPorDefecto() {
        listaTablets.add(new Tablets("iPad Pro 11", 799.99, "Pantalla 11\" - 6 GB RAM"));
        listaTablets.add(new Tablets("Samsung Galaxy Tab S7", 649.99, "Pantalla 11\" - 8 GB RAM"));
        listaTablets.add(new Tablets("Microsoft Surface Pro 7", 899.99, "Pantalla 12.3\" - 8 GB RAM"));
    }
}