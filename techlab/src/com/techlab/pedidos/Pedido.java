package com.techlab.pedidos;

import java.util.ArrayList;

public class Pedido {

    private static int contadorId = 1;
    private int id;
    private ArrayList<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {
        this.id = contadorId++;
    }

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    // Calcula el total sumando todos los subtotales
    public double calcularTotal() {
        double total = 0;
        for (LineaPedido l : lineas) {
            total += l.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Pedido #").append(id).append(" ---\n");
        for (LineaPedido l : lineas) {
            sb.append("  ").append(l).append("\n");
        }
        sb.append("  TOTAL: $").append(calcularTotal());
        return sb.toString();
    }
}