package practicaStream.ejercicio2.main;

import practicaStream.ejercicio2.entidades.Cliente;
import practicaStream.ejercicio2.entidades.Pedido;
import practicaStream.ejercicio2.entidades.Producto;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Pedido pedido1 = new Pedido(LocalDate.now(), LocalDate.now().plusDays(5),
                Pedido.EstadoProducto.RECIBIDO, cliente1);
        Pedido pedido2 = new Pedido(LocalDate.now().plusDays(1), LocalDate.now().plusDays(7),
                Pedido.EstadoProducto.RECIBIDO, cliente2);
        Pedido pedido3 = new Pedido(LocalDate.now(), LocalDate.now().plusDays(3),
                Pedido.EstadoProducto.RECIBIDO, cliente3);
        Pedido pedido4 = new Pedido(LocalDate.now().plusDays(3), LocalDate.now().plusDays(8),
                Pedido.EstadoProducto.RECIBIDO, cliente1);

        pedido1.setProductos(new HashSet<>(List.of(producto1, producto3, producto5, producto7)));
        pedido2.setProductos(new HashSet<>(List.of(producto2, producto4, producto6, producto8, producto10)));
        pedido3.setProductos(new HashSet<>(List.of(producto11, producto12, producto13, producto14, producto15)));
        pedido4.setProductos(new HashSet<>(List.of(producto9, producto3, producto6, producto10)));

        ArrayList<Pedido> pedidos = new ArrayList<>(List.of(pedido1, pedido2, pedido3, pedido4));

        //STREAMS------------------------------------
        //1. Muestra los libros cuyo precio sea mayor de 20€
        pedidos.stream()
                .flatMap(pedido -> pedido.getProductos().stream()
                        .distinct()
                        .filter(producto -> producto.getCategoria().equals(Producto.CategoriaProducto.LIBROS))
                        .filter(producto -> producto.getPrecio() > 20))
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
        //2. Muestra los pedidos que tengan algún pedido de "Juegos"
        pedidos.stream()
                .filter(pedido -> pedido.getProductos().stream()
                        .anyMatch(producto -> producto.getCategoria()
                                .equals(Producto.CategoriaProducto.JUEGOS)))
                .forEach(System.out::println);

        System.out.println("---------------------------------------");
        //3. Genera una lista con todos los Libros pero cambia su precio para que lleven un 10% de descuento
        pedidos.stream()
                .flatMap(pedido -> pedido.getProductos().stream()
                        .peek(producto -> producto.setPrecio(producto.getPrecio() * 1.10)))
                .forEach(System.out::println);

        System.out.println("---------------------------------------");

        //4. Saca los productos que aparecen en los pedidos de clientes de nivel 2, realizados entre el 20-04-
        //2022 y el 20-05-2022. Hay que usar flatmap para unir todos los productos de todos los pedidos:
        //.flatMap( p -> p.getProductos().stream())
        pedidos.stream()
                .filter(pedido -> pedido.getCliente().getNivel().equals(2))
                .filter(pedido -> pedido.getFechaPedido().isAfter(LocalDate.of(2024, 04, 10))
                        && pedido.getFechaPedido().isBefore(LocalDate.of(2024, 05, 20)))
                .flatMap(pedido -> pedido.getProductos().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------------------------");

        //5. Muestra el producto más caro de la categoría Juegos
        Producto precioMaximo = List.of(producto1, producto2, producto3, producto4, producto5, producto6, producto7,
                        producto8, producto9, producto10, producto11, producto12, producto13, producto14, producto15).stream()
                .filter(producto -> producto.getCategoria().equals(Producto.CategoriaProducto.JUEGOS))
                .max(Comparator.comparing(Producto::getPrecio))
                .orElse(null);

        System.out.println(precioMaximo);

        System.out.println("---------------------------------------");
        //6. Devuelve los dos pedidos más recientes
        pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getFechaPedido).reversed())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("---------------------------------------");


        //7. Muestra los pedidos hechos hoy, debe aparecer el pedido y debajo la lista de productos de ese
        //pedido (peek y flatmap)
        pedidos.stream()
                .filter(pedido -> pedido.getFechaPedido().equals(LocalDate.now()))
                .peek(pedido -> System.out.println("Pedido: " + pedido.getId()))
                .forEach(pedido -> pedido.getProductos().stream()
                        .forEach(System.out::println));

        System.out.println("---------------------------------------");

        //8. Calcula el total de todos los pedidos de Abril de 2022
        Double precioTotal = pedidos.stream()
                .filter(pedido -> pedido.getFechaPedido().getMonth().equals(Month.APRIL))
                .flatMap(pedido -> pedido.getProductos().stream())
                .mapToDouble(Producto::getPrecio)
                .sum();
        System.out.println(precioTotal + " € ");

        System.out.println("---------------------------------------");


        //9. Obtén una colección de estadísticas de los Juegos: número, media, máximo, mínimo, total. Hay que
        //usar el método de Streams summaryStatistics() que devuelve un DoubleSummaryStatistics.
        String estadísticas = pedidos.stream()
                    .flatMap(pedido -> pedido.getProductos().stream())
                    .filter(producto -> producto.getCategoria().equals(Producto.CategoriaProducto.JUEGOS))
                    .collect(Collectors.summarizingDouble(Producto::getPrecio))
                    .toString();
        System.out.println(estadísticas);
        System.out.println("---------------------------------------");

        //10. Genera un Map<Long, Integer> donde como clave aparezca el id de pedido y como valor el número
        //de productos en el pedido. Collectors.toMap, que el primer parámetro será función lambda para
        //quedarnos con el id, y el segundo parámetro una función lambda para el tamaño del Set de
        //productos.
        Map<Long, Integer> mapa = pedidos.stream()
                .collect(Collectors.toMap(Pedido::getId, pedido -> pedido.getProductos().size()));
        mapa.forEach((k,v) -> System.out.println("Pedido: " + k + " nº de productos: " + v));
        System.out.println("---------------------------------------");



        //11. Genera un Map<Pedido, Double> donde la clave sea cada pedido y el valor sea el total del pedido.
        //Hay que usar Collectors.toMap pero al poner la clave es el propio pedido, se pone
        //Function.identity() en el primer parámetro de Collectors.toMap.
        Map<Pedido, Double> valorPedidos = pedidos.stream()
                .collect(Collectors.toMap(Function.identity(), pedido -> pedido.getProductos().stream()
                                                                .mapToDouble(Producto::getPrecio)
                                                                .sum()));
        valorPedidos.forEach((k,v) -> System.out.println("Pedido: " + k + " total pedido: " + v));
        System.out.println("---------------------------------------");


        //12. Genera un Map<String, List<Producto>> con la clave la categoría, y el valor los productos de esa
        //categoría. Usar Collectors.groupingBy.
        Map<Producto.CategoriaProducto, List<Producto>> productosPorCategoria = pedidos.stream()
                .flatMap(pedido -> pedido.getProductos().stream())
                .collect(Collectors.groupingBy(Producto::getCategoria));
        productosPorCategoria.forEach((k,v) -> {System.out.println("Producto: " + k);
                                            v.forEach(System.out::println);
        });


        System.out.println("---------------------------------------");
        //13. Saca el producto más caro de cada categoría. Genera un Map<String, Optional<Producto>>. Usar
        //Collectors.groupingBy y Collectors.maxBy.
        Map<Producto.CategoriaProducto, Optional<Producto>> productoMasCaroCategoria = pedidos.stream()
                .flatMap(pedido -> pedido.getProductos().stream())
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Producto::getPrecio))));

        productoMasCaroCategoria.forEach((k,v) -> System.out.println("Producto: " + k + " - " + v.orElse(null)));





    }
}
