package CELULAR;

import java.util.ArrayList;
import java.util.List;

public class ControladorCelulares {
    private List<Celular> listaCelulares;

    // Constructor
    public ControladorCelulares() {
        listaCelulares = new ArrayList<>();
        // Añadir algunos celulares de ejemplo
        listaCelulares.add(new Celular("iPhone 14", 999.99, "Pantalla OLED, Cámara 12MP, 128GB"));
        listaCelulares.add(new Celular("Samsung Galaxy S23", 799.99, "Pantalla AMOLED, Cámara 50MP, 256GB"));
        listaCelulares.add(new Celular("Xiaomi 13 Pro", 599.99, "Pantalla AMOLED, Cámara 108MP, 256GB"));
    }

    // Método para obtener la lista de celulares
    public List<Celular> getListaCelulares() {
        return listaCelulares;
    }

    // Método para obtener un celular por su modelo
    public Celular getCelularPorModelo(String modelo) {
        for (Celular celular : listaCelulares) {
            if (celular.getModelo().equals(modelo)) {
                return celular;
            }
        }
        return null; // Si no se encuentra el celular
    }
}