package com.techlab.productos;

public class Producto {

    //Atributos (los datos que tiene cada producto)
    private static int contadorId = 1; //Para autogenerar IDs
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    //Constructor: se ejecuta cuando creas un objeto nuevo
    public Producto(String nombre, double precio, int stock){
        this.id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters: permiten leer los atributos desde fuera
    public int getId(){ return id;}
    public String getNombre(){ return nombre;}
    public double getPrecio(){return precio;}
    public int getStock(){return stock;}

    //Setters: permiten modificar los atributos
    public void setPrecio(double precio){this.precio = precio;}
    public void setStock(int stock){this.stock = stock;}

    //toString: como se muestra el producto en la pantalla
    @Override
    public String toString() {
         return "[ID: " + id + "] " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
}