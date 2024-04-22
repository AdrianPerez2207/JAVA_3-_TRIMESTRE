package practica2_streams.ejercicio2.main;

import practica2_streams.ejercicio2.entidades.Ciudad;
import practica2_streams.ejercicio2.entidades.Continente;
import practica2_streams.ejercicio2.entidades.Pais;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TestCapitales {
    public static void main(String[] args) {
        //String nombre, Continente continente, Double superficie, Integer poblacion, Ciudad capital
        //String nombre, Integer poblacion, Pais pais

        Pais Espanha = new Pais("España", Continente.Europa, 506030.0, 47000000);
        Ciudad Madrid = new Ciudad("Madrid",3223000, Espanha);
        Ciudad Almeria = new Ciudad("Almeria", 196851, Espanha);
        Ciudad Murcia = new Ciudad("Murcia", 447182, Espanha);
        Espanha.setCapital(Madrid);
        Espanha.addCiudad(Madrid);
        Espanha.addCiudad(Almeria);
        Espanha.addCiudad(Murcia);

        Pais Alemania = new Pais("Alemania", Continente.Europa, 320890.0, 84000000);
        Ciudad Berlin = new Ciudad("Berlin", 356291, Alemania);
        Ciudad Hamburgo = new Ciudad("Hamburgo", 75516, Alemania);
        Ciudad Munich = new Ciudad("Munich", 356291, Alemania);
        Alemania.setCapital(Berlin);
        Alemania.addCiudad(Berlin);
        Alemania.addCiudad(Hamburgo);
        Alemania.addCiudad(Munich);

        Pais Mexico = new Pais("México", Continente.America_del_Sur, 1950000.0, 100000000);
        Ciudad Ciudad_de_Mexico = new Ciudad("Ciudad de México", 195000000, Mexico);
        Ciudad Oaxaca_de_Juarez = new Ciudad("Oaxaca de Juarez", 3209832, Mexico);
        Ciudad Veracruz = new Ciudad("Veracruz", 4352609, Mexico);
        Mexico.setCapital(Ciudad_de_Mexico);
        Mexico.addCiudad(Ciudad_de_Mexico);
        Mexico.addCiudad(Oaxaca_de_Juarez);
        Mexico.addCiudad(Veracruz);

        Pais Brasil = new Pais("Brasil", Continente.America_del_Sur, 19540000.0, 215000000);
        Ciudad Brasilia = new Ciudad("Brasilia", 21500000, Brasil);
        Ciudad Rio_de_Janeiro = new Ciudad("Rio de Janeiro", 21505000, Brasil);
        Ciudad Sao_Paulo = new Ciudad("Sao Paulo", 21500000, Brasil);
        Brasil.setCapital(Brasilia);
        Brasil.addCiudad(Brasilia);
        Brasil.addCiudad(Rio_de_Janeiro);
        Brasil.addCiudad(Sao_Paulo);

        Pais Tailandia = new Pais("Tailandia", Continente.Asia, 1453426.0, 124568760);
        Ciudad Bangkok = new Ciudad("Bangkok", 12050000, Tailandia);
        Ciudad Ayutthaya = new Ciudad("Ayutthaya", 10000000, Tailandia);
        Ciudad Nan = new Ciudad("Nan", 22000567, Tailandia);
        Tailandia.setCapital(Bangkok);
        Tailandia.addCiudad(Bangkok);
        Tailandia.addCiudad(Ayutthaya);
        Tailandia.addCiudad(Nan);

        Pais Japon = new Pais("Japón", Continente.Asia, 378000.0, 125000000);
        Ciudad Tokio = new Ciudad("Tokio", 9000000, Japon);
        Ciudad Osaka = new Ciudad("Osaka", 10000000, Japon);
        Ciudad Nagoya = new Ciudad("Nagoya", 10000000, Japon);
        Japon.setCapital(Tokio);
        Japon.addCiudad(Tokio);
        Japon.addCiudad(Osaka);
        Japon.addCiudad(Nagoya);

        Pais India = new Pais("India", Continente.Asia, 3287590.0, 125000000);
        Ciudad Delhi = new Ciudad("Delhi", 10000000, India);
        Ciudad Mumbai = new Ciudad("Mumbai", 10000000, India);
        Ciudad Kolkata = new Ciudad("Kolkata", 10000000, India);
        India.setCapital(Delhi);
        India.addCiudad(Delhi);
        India.addCiudad(Mumbai);
        India.addCiudad(Kolkata);

        Pais China = new Pais("China", Continente.Asia, 9600000.0, 125000000);
        Ciudad Beijing = new Ciudad("Beijing", 10000000, China);
        Ciudad Shanghai = new Ciudad("Shanghai", 10000000, China);
        Ciudad Guangzhou = new Ciudad("Guangzhou", 10000000, China);
        China.setCapital(Beijing);
        China.addCiudad(Beijing);
        China.addCiudad(Shanghai);
        China.addCiudad(Guangzhou);

        Pais Rusia = new Pais("Rusia", Continente.Europa, 17000000.0, 144000000);
        Ciudad Moscu = new Ciudad("Moscú", 12300000, Rusia);
        Ciudad St_Petersburg = new Ciudad("St Petersburg", 100000, Rusia);
        Ciudad Volgograd = new Ciudad("Volgograd", 1540000, Rusia);
        Rusia.setCapital(Moscu);
        Rusia.addCiudad(Moscu);
        Rusia.addCiudad(St_Petersburg);
        Rusia.addCiudad(Volgograd);

        Pais Estados_Unidos = new Pais("Estados Unidos", Continente.America_del_Norte, 9600000.0, 325000000);
        Ciudad Washington = new Ciudad("Washington", 10000000, Estados_Unidos);
        Ciudad Los_Angeles = new Ciudad("Los Angeles", 10000000, Estados_Unidos);
        Ciudad Chicago = new Ciudad("Chicago", 10000000, Estados_Unidos);
        Estados_Unidos.setCapital(Washington);
        Estados_Unidos.addCiudad(Washington);
        Estados_Unidos.addCiudad(Los_Angeles);
        Estados_Unidos.addCiudad(Chicago);

        List<Pais> paises = new ArrayList<Pais>(List.of(Estados_Unidos, Espanha, Tailandia, Alemania, Rusia, China,
                Japon, Brasil, Mexico, India));

        //Streams
        System.out.println("Menor superficie: ");
        paises.stream()
                .min(Comparator.comparing(Pais::getSuperficie))
                .ifPresent(System.out::println);

        System.out.println("------------------------");
        System.out.println("Países ordenados por población: ");
        paises.stream()
                .sorted(Comparator.comparing(Pais::getPoblacion).reversed())
                .forEach(pais -> System.out.println("País: " + pais.getNombre() + " - " + "Población: " + pais.getPoblacion()));

        System.out.println("------------------------");
        System.out.println("Países con más superficie: ");
        paises.stream()
                .sorted(Comparator.comparing(Pais::getSuperficie).reversed())
                .limit(5)
                .forEach(pais -> System.out.println("País: " + pais.getNombre() + " - " + "Superficie: " + pais.getSuperficie()));

        System.out.println("------------------------");
        System.out.println("Países de América del Norte y Sur: ");
        paises.stream()
                .filter(pais -> pais.getContinente().equals(Continente.America_del_Norte) ||
                        pais.getContinente().equals(Continente.America_del_Sur))
                .sorted(Comparator.comparing(Pais::getPoblacion))
                .forEach(System.out::println);

        System.out.println("------------------------");
        System.out.println("Capitales ordenadas alfabéticamente: ");
        paises.stream()
                .map(Pais::getCapital)
                .sorted(Comparator.comparing(Ciudad::getNombre))
                .forEach(System.out::println);

        System.out.println("------------------------");
        System.out.println("Capitales más pobladas: ");
        paises.stream()
                .map(Pais::getCapital)
                .sorted(Comparator.comparing(Ciudad::getPoblacion).reversed())
                .limit(3)
                .forEach(capital -> System.out.println("Capital: " + capital.getNombre() + " - " + "Población: " + capital.getPoblacion()));

        System.out.println("------------------------");
        System.out.println("Continentes más los países: ");
        paises.stream()
                .collect(Collectors.groupingBy(Pais::getContinente))
                .forEach((continente, valores) -> {
                    System.out.println("------- " + continente + " -------");
                    valores.forEach(pais -> System.out.println(pais.getNombre()));
                });


        System.out.println("------------------------");
        System.out.println("Mostrar si todos los países tienen más de 20 millones de habitantes: ");
        //Comprobamos el resultado de allMatch con ternarias, guardamos el resultado en una variable y la pintamos.
        //No podemos pintar directamente en la función.
        String mayor20millones = paises.stream()
                .allMatch(pais -> pais.getPoblacion() > 20000000)
                //Si coincide, pintará lo de la interrogación.
                ? "Todos los países tienen más de 20 millones de habitantes"
                : "No todos los países";
        System.out.println(mayor20millones);

        System.out.println("------------------------");
        System.out.println("Media de población de todos los países: ");
        Double mediaPaises = paises.stream()
                .collect(Collectors.averagingDouble(Pais::getPoblacion));
        System.out.println("Media de población: " + mediaPaises);

        System.out.println(paises.stream()
                .collect(Collectors.summarizingDouble(Pais::getPoblacion))
                .getAverage());

        System.out.println("------------------------");
        System.out.println("Continentes y cuenta de sus países: ");
        paises.stream()
                .collect(Collectors.groupingBy(Pais::getContinente, Collectors.counting()))
                .forEach((continente, valores) -> {
                    System.out.println(continente + ": " + valores);
                });

        System.out.println("------------------------");
        System.out.println("Países ordenados por superficie + países ordenados por población: ");
        paises.stream()
                .sorted(Comparator.comparing(Pais::getSuperficie))
                .forEach(pais -> {System.out.println("País: " + pais.getNombre() + " - Superficie: " + pais.getSuperficie());
                    pais.getCiudades().stream()
                            .sorted(Comparator.comparing(Ciudad::getPoblacion))
                            .forEach(ciudad -> System.out.println("Ciudad: " + ciudad.getNombre() + " - " + " Población: "
                                    + ciudad.getPoblacion()));
                });

        System.out.println("------------------------");
        System.out.println("Países y la suma de su población: ");
        paises.stream()
                .forEach(pais -> {
                    System.out.println("País: " + pais.getNombre());
                    Double suma = pais.getCiudades().stream()
                            .mapToDouble(Ciudad::getPoblacion)
                            .sum();
                    System.out.println("Población total: " + suma);
                });


        System.out.println("------------------------");
        System.out.println("Capital más poblada: ");
        paises.stream()
                .map(Pais::getCapital)
                .max(Comparator.comparing(Ciudad::getPoblacion))
                .ifPresent(System.out::println);

        System.out.println("------------------------");
        System.out.println("Países ordenados por densidad de población: ");
        paises.stream()
                .sorted(Comparator.comparing(pais -> pais.getPoblacion() / pais.getSuperficie()))
                .forEach(pais -> System.out.println("País: " + pais.getNombre() + " - " + "Densidad: " + pais.getPoblacion() / pais.getSuperficie()));

        System.out.println("------------------------");
        System.out.println("Primera capital que empiece por 'B':");
        paises.stream()
                .map(Pais::getCapital)
                .filter(capital -> capital.getNombre().startsWith("B"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("------------------------");
        System.out.println("País con su ciudad más poblada: ");
        paises.stream()
                .forEach(pais -> {
                    System.out.println("País: " + pais.getNombre());
                    pais.getCiudades().stream()
                            .max(Comparator.comparing(Ciudad::getPoblacion))
                            .ifPresent(ciudad -> System.out.println("Ciudad: " + ciudad.getNombre() + " - " + "Población: "
                                    + ciudad.getPoblacion()));
                });
        System.out.println("------------------------");
        System.out.println("Ciudad más poblada: ");
        paises.stream()
                .flatMap(pais -> pais.getCiudades().stream())
                .max(Comparator.comparing(Ciudad::getPoblacion))
                .ifPresent(ciudad -> System.out.println("Ciudad: " + ciudad.getNombre() + " - " + "Población: "
                        + ciudad.getPoblacion()));
    }
}
