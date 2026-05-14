SISTEMA DE GESTIÓN - TECHLAB
=============================

Sistema de gestión de productos y pedidos desarrollado en Java.
Permite registrar, visualizar y administrar productos, así como
crear y consultar pedidos con validación de stock.


FUNCIONALIDADES
---------------
1) Agregar producto: registra nombre, precio y stock.
2) Listar productos: muestra todos los productos con su ID.
3) Buscar/Actualizar producto: busca por ID y permite modificar precio o stock.
4) Eliminar producto: elimina un producto por su ID.
5) Crear pedido: genera un pedido validando stock disponible.
6) Listar pedidos: muestra todos los pedidos con su total.


ESTRUCTURA DEL PROYECTO
------------------------
src/
└── com/
    └── techlab/
        ├── Main.java
        ├── productos/
        │   ├── Producto.java
        │   └── ProductoService.java
        ├── pedidos/
        │   ├── Pedido.java
        │   ├── LineaPedido.java
        │   └── PedidoService.java
        └── excepciones/
            └── StockInsuficienteException.java


TECNOLOGÍAS UTILIZADAS
-----------------------
- Lenguaje: Java
- POO: clases, objetos, encapsulamiento
- Colecciones: ArrayList
- Excepciones: try/catch y excepción personalizada (StockInsuficienteException)
- Organización: paquetes lógicos
- Entrada de datos: Scanner por consola


CÓMO EJECUTAR
--------------
1. Abrí el proyecto en Visual Studio Code.
2. Asegurate de tener instalada la extensión "Extension Pack for Java".
3. Abrí el archivo Main.java y hacé clic en "Run Java".


AUTOR
------
Desarrollado como preentrega del Proyecto Final Integrador - cursada Java.
