package com.techlab;

import com.techlab.productos.ProductoService;
import com.techlab.pedidos.PedidoService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService(productoService);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n====================================");
            System.out.println("   SISTEMA DE GESTIÓN - TECHLAB");
            System.out.println("====================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("✗ Ingresá un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> agregarProducto(productoService, scanner);
                case 2 -> productoService.listarProductos();
                case 3 -> buscarActualizar(productoService, scanner);
                case 4 -> eliminarProducto(productoService, scanner);
                case 5 -> pedidoService.crearPedido(scanner);
                case 6 -> pedidoService.listarPedidos();
                case 7 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("✗ Opción no válida.");
            }
        }

        scanner.close();
    }

    static void agregarProducto(ProductoService ps, Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        double precio = 0;
        int stock = 0;

        try {
            System.out.print("Precio: ");
            precio = Double.parseDouble(sc.nextLine());

            System.out.print("Stock: ");
            stock = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✗ Precio o stock inválido.");
            return;
        }

        ps.agregarProducto(nombre, precio, stock);
    }

    static void buscarActualizar(ProductoService ps, Scanner sc) {
        System.out.print("Ingresá el ID del producto: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            var producto = ps.buscarPorId(id);
            if (producto == null) {
                System.out.println("✗ Producto no encontrado.");
                return;
            }
            System.out.println("Producto encontrado: " + producto);
            System.out.print("¿Querés actualizar? (s/n): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Nuevo precio: ");
                producto.setPrecio(Double.parseDouble(sc.nextLine()));
                System.out.print("Nuevo stock: ");
                producto.setStock(Integer.parseInt(sc.nextLine()));
                System.out.println("✓ Producto actualizado: " + producto);
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Valor inválido.");
        }
    }

    static void eliminarProducto(ProductoService ps, Scanner sc) {
        System.out.print("Ingresá el ID del producto a eliminar: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            ps.eliminarProducto(id);
        } catch (NumberFormatException e) {
            System.out.println("✗ ID inválido.");
        }
    }
}