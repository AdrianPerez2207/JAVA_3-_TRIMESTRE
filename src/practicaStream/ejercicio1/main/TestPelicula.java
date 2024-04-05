package practicaStream.ejercicio1.main;

import practicaStream.ejercicio1.entidades.Director;
import practicaStream.ejercicio1.entidades.Genero;
import practicaStream.ejercicio1.entidades.Pelicula;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TestPelicula {

    public static void main(String[] args) {
        //Gérenos
        Genero g1 = new Genero("Ciencia Ficción");
        Genero g2 = new Genero("Drama");
        Genero g3 = new Genero("Comedia");
        Genero g4 = new Genero("Historia");
        Genero g5 = new Genero("Terror");
        Genero g6 = new Genero("Mafia");
        //Directores
        Director d1 = new Director("Ridley Scott");
        Director d2 = new Director("F.F. Coppola");
        Director d3 = new Director("C.Nolan");
        Director d4 = new Director("Martin Scorsese");
        Director d5 = new Director("Quentin Tarantino");
        //Películas
        Pelicula p1 = new Pelicula("Pull Fiction", 1999);
        Pelicula p2 = new Pelicula("Reservoir Dogs", 1991);
        Pelicula p3 = new Pelicula("Gladiator", 2000);
        Pelicula p4 = new Pelicula("Blade Runner", 2000);
        Pelicula p5 = new Pelicula("Alien", 2003);
        Pelicula p6 = new Pelicula("Apocalypse now", 2008);
        Pelicula p7 = new Pelicula("El Padrino", 2001);
        Pelicula p8 = new Pelicula("Tenet", 2018);
        Pelicula p9 = new Pelicula("Origen", 2019);
        Pelicula p10 = new Pelicula("Casino", 2015);
        Pelicula p11 = new Pelicula("Godfellas", 2015);
        Pelicula p12 = new Pelicula("El lobo de Wall Street", 2016);
        //Añadimos los Géneros
        p1.getGeneros().addAll(List.of(g1, g5, g6));
        p2.getGeneros().addAll(List.of(g2, g6));
        p3.getGeneros().addAll(List.of(g5, g6));
        p4.getGeneros().addAll(List.of(g3, g5, g6));
        p5.getGeneros().addAll(List.of(g4, g6));
        p6.getGeneros().addAll(List.of(g1, g2));
        p7.getGeneros().addAll(List.of(g2, g3));
        p8.getGeneros().addAll(List.of(g1, g5, g6));
        p9.getGeneros().addAll(List.of(g4, g5));
        p10.getGeneros().addAll(List.of(g5, g6));
        p11.getGeneros().addAll(List.of(g1, g3));
        p12.getGeneros().addAll(List.of(g2, g3));
        //Añadimos los Directores
        p1.getDirectores().addAll(List.of(d1));
        p2.getDirectores().addAll(List.of(d2, d4));
        p3.getDirectores().addAll(List.of(d3, d5));
        p4.getDirectores().addAll(List.of(d1));
        p5.getDirectores().addAll(List.of(d1, d2));
        p6.getDirectores().addAll(List.of(d4, d5));
        p7.getDirectores().addAll(List.of(d3));
        p8.getDirectores().addAll(List.of(d2, d5));
        p9.getDirectores().addAll(List.of(d4, d5));
        p10.getDirectores().addAll(List.of(d2,d3));
        p11.getDirectores().addAll(List.of(d1, d4));
        p12.getDirectores().addAll(List.of(d2, d3));

        //Stream
        /**
         * Peliculas ordenadas por años
         */
        System.out.println("Películas ordenadas por año: ");
        Stream.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
                .sorted(Comparator.comparing(Pelicula::getAnio))
                .forEach(System.out::println);
        System.out.println();
        /**
         * Filtramos el año, despúes filtramos los géneros de las películas (pasamos los géneros a Stream y con anyMatch
         * buscamos que contenga nuestro género)
         */
        System.out.println("Películas de Ciencia Ficción posteriores al 2000: ");
        Stream.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
                .filter(pelicula -> pelicula.getAnio() > 2000)
                .filter(pelicula -> pelicula.getGeneros().stream()
                        .anyMatch(genero -> genero.getNombre().equals("Ciencia Ficción")))
                .forEach(System.out::println);
        System.out.println();

        /**
         * tituloMasLargo(): muestra la película cuyo título es más largo
         * Para comparar el máximo, comparamos las longitudes cómo números enteros.
         * Si hay alguno más largo (ifPresent) lo pintamos.
         */
        System.out.println("Película con título más largo: ");
        Stream.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
                .max(Comparator.comparingInt(pelicula -> pelicula.getTitulo().length()))
                .ifPresent(System.out::println);
        System.out.println();

        /**
         * directoresMayúsculas(): muestra los nombres de los directores ordenados y en mayúsculas.
         * Con flatMap nos quedamos solo con los directores de las películas y lo pasamos a Stream
         * Con sorted lo ordenamos, con distrinct nos no pinta los repetidos
         * Con forEach pintamos los nombres de los directores en Mayúsculas.
         */
        System.out.println("Directores ordenados y en mayúsculas: ");
        Stream.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
                .flatMap(pelicula -> pelicula.getDirectores().stream())
                .sorted(Comparator.comparing(Director::getNombre))
                .distinct()
                .forEach(director -> System.out.println(director.getNombre().toUpperCase()));
        System.out.println();

    }
}
