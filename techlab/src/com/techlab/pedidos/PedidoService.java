package com.techlab.pedidos;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ProductoService productoService;

    public PedidoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void crearPedido(Scanner sc) {
        Pedido pedido = new Pedido();

        System.out.print("¿Cuántos productos querés agregar al pedido? ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✗ Valor inválido.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.print("ID del producto: ");
            int id;
            int cantPedida;
            try {
                id = Integer.parseInt(sc.nextLine());
                System.out.print("Cantidad: ");
                cantPedida = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("✗ Valor inválido, saltando este producto.");
                continue;
            }

            Producto p = productoService.buscarPorId(id);
            if (p == null) {
                System.out.println("✗ Producto no encontrado, saltando.");
                continue;
            }

            try {
                if (cantPedida > p.getStock()) {
                    throw new StockInsuficienteException(p.getNombre(), p.getStock());
                }
                // Descontar stock y agregar al pedido
                p.setStock(p.getStock() - cantPedida);
                pedido.agregarLinea(new LineaPedido(p, cantPedida));
                System.out.println("✓ Agregado: " + p.getNombre() + " x" + cantPedida);

            } catch (StockInsuficienteException e) {
                System.out.println("✗ " + e.getMessage());
            }
        }

        pedidos.add(pedido);
        System.out.println("✓ Pedido creado:" + pedido);
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}