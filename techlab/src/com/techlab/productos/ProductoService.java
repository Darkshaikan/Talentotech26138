package com.techlab.productos;
import java.util.ArrayList;

public class ProductoService {
    
    //La lista donde guardamos todos los productos
    private ArrayList<Producto> productos = new ArrayList<>();

    //Agregar un producto nuevo
    public void agregarProducto(String nombre, double precio, int stock){
        Producto p = new Producto(nombre, precio, stock);
        productos.add(p);
        System.out.println("Producto agregado: " + p);
    }

    //Listar todos los productos
    public void listarProductos(){
        if (productos.isEmpty()){
            System.out.println("No hay productos registrados.");
            return;
        }
        System.err.println("\n ---Lista de productos ---");
        for (Producto p : productos){
            System.out.println(p);
        }
    }

    //Buscar por ID
    public Producto buscarPorId(int id){
        for (Producto p : productos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    //Eliminar por ID
    public void eliminarProducto(int id){
        Producto p = buscarPorId(id);
        if (p != null){
            productos.remove(p);
            System.out.println("Producto eliminado: " + p.getNombre());

        }else {
            System.out.println("No se encontro producto con ID " + id);

        }
    }

    //Getter de la lista (Lo necesitaremos para los pedidos)
    public ArrayList<Producto> geProductos(){
        return productos;
    }
}
