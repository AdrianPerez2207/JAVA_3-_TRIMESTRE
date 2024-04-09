package practicaStream.ejercicio2.main;

import practicaStream.ejercicio2.entidades.Cliente;
import practicaStream.ejercicio2.entidades.Producto;

public class TestPedidos {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Antonio", 1);
        Cliente cliente2 = new Cliente("Juan", 2);
        Cliente cliente3 = new Cliente("Pedro", 3);

        Producto producto1 = new Producto("Libro 1", Producto.CategoriaProducto.LIBROS, 19.95);
        Producto producto2 = new Producto("Libro 2", Producto.CategoriaProducto.LIBROS, 18.75);
        Producto producto3 = new Producto("Libro 3", Producto.CategoriaProducto.LIBROS, 21.00);
        Producto producto4 = new Producto("Libro 4", Producto.CategoriaProducto.LIBROS, 15.50);
        Producto producto5 = new Producto("Libro 5", Producto.CategoriaProducto.LIBROS, 22.99);

        Producto producto6 = new Producto("Juego 1", Producto.CategoriaProducto.JUEGOS, 35.00);
        Producto producto7 = new Producto("Juego 2", Producto.CategoriaProducto.JUEGOS, 56.99);
        Producto producto8 = new Producto("Juego 3", Producto.CategoriaProducto.JUEGOS, 69.99);
        Producto producto9 = new Producto("Juego 4", Producto.CategoriaProducto.JUEGOS, 24.50);
        Producto producto10 = new Producto("Juego 5", Producto.CategoriaProducto.JUEGOS, 10.99);

        Producto producto11 = new Producto("Periferico 1", Producto.CategoriaProducto.PERIFERICOS, 22.15);
        Producto producto12 = new Producto("Periferico 2", Producto.CategoriaProducto.PERIFERICOS, 75.80);
        Producto producto13 = new Producto("Periferico 3", Producto.CategoriaProducto.PERIFERICOS, 52.2);
        Producto producto14 = new Producto("Periferico 4", Producto.CategoriaProducto.PERIFERICOS, 23.3);
        Producto producto15 = new Producto("Periferico 5", Producto.CategoriaProducto.PERIFERICOS, 63.8);




    }
}
