
package PC;


import java.util.ArrayList;
import java.util.List;

public class ControladorPC {

    private List<Pc> listaPCs;

    // Constructor
    public ControladorPC() {
        this.listaPCs = new ArrayList<>();
        // Cargar algunos PCs por defecto (si lo necesitas)
        cargarPCsPorDefecto();
    }

    // Método para obtener la lista de PCs
    public List<Pc> getListaPCs() {
        return listaPCs;
    }

    public Pc getPCPorModelo(String modelo) {
    for (Pc pc : listaPCs) {
        if (pc.getModelo().equals(modelo)) {
            return pc;
        }
    }
    return null; // Si no se encuentra la PC
}
    
    // Método para agregar un PC a la lista
    public void agregarPC(Pc pc) {
        listaPCs.add(pc);
    }

    // Método para cargar algunos PCs de ejemplo
    private void cargarPCsPorDefecto() {
        listaPCs.add(new Pc("Dell XPS 13", 1299.99, "Intel i7, 16GB RAM, 512GB SSD"));
        listaPCs.add(new Pc("MacBook Pro 16\"", 2399.99, "Intel i9, 32GB RAM, 1TB SSD"));
        listaPCs.add(new Pc("HP Spectre x360", 1499.99, "Intel i7, 16GB RAM, 512GB SSD"));
    }
}