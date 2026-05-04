package com.techlab.excepciones;

public class StockInsuficienteException extends Exception {
    
    public StockInsuficienteException(String nombreProducto, int stockDisponible){
        super("Stock insuficiente para '" + nombreProducto + "'. Stock disponible: " + stockDisponible);
    }
}
