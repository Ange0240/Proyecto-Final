package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private static Carrito instancia; // Singleton
    private List<Producto> productos; // Lista de productos del carrito
    private List<Producto> listaDeseos; // Lista de productos de deseos

    Carrito() {
        productos = new ArrayList<>();
        listaDeseos = new ArrayList<>();
    }

    // Método para obtener la única instancia del carrito
    public static Carrito getInstancia() {
        if (instancia == null) {
            instancia = new Carrito();
        }
        return instancia;
    }

    // Métodos para gestionar productos del carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProductoPorNombre(String nombreProducto) {
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto));
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    // Métodos para gestionar lista de deseos
    public void agregarDeseo(Producto producto) {
        listaDeseos.add(producto);
    }

    public void eliminarDeseoPorNombre(String nombreProducto) {
        listaDeseos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto));
    }

    public List<Producto> obtenerListaDeseos() {
        return listaDeseos;
    }
}

