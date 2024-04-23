package practica3_ficheros.io;

import practica3_ficheros.entidades.Finca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DAOFinca {

    private static ArrayList<Finca> fincas;

    public DAOFinca() throws IOException {
        fincas = new ArrayList<>(cargarDatos());
    }

    public static ArrayList<Finca> getFincas() {
        return fincas;
    }

    //Métodos---
    private static List<Finca> cargarDatos() throws IOException {
        Path ficheroFincas = Paths.get("src", "practica3_ficheros", "resources", "fincas.csv");
        return Files.lines(ficheroFincas)
                .map(str -> {
                    String[] cad = str.split(",");

                    //Creamos el objeto
                    return new Finca(Long.parseLong(cad[0]), cad[1], Double.parseDouble(cad[2]), Double.parseDouble(cad[3]),
                            Double.parseDouble(cad[4]), cad[5], cad[6]);
                })
                .toList();
    }
    public static void addFinca(Finca finca){
        fincas.add(finca);
    }
    public static void deleteFinca(Finca finca){
        fincas.remove(finca);
    }

    /**
     * Filtramos todas las fincas y buscamos la que coincida con el id pasado por parámetro.
     * @param id
     */
    public static Finca findById(Long id){
        return fincas.stream()
                .filter(finca -> finca.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    /**
     * Filtramos todas las fincas y buscamos la que coincida con el nombre.
     * @param nombre
     * @return la finca encontrada.
     */
    public static Finca findByName(String nombre){
        return fincas.stream()
               .filter(finca -> finca.getNombre().equals(nombre))
                .findFirst()
               .orElseThrow();
    }
    //Streams

    /**
     * Ordenamos las fincas por superficie de menor a mayor.
     * @return
     */
    public static List<Finca> getFincasPorSuperficie(){
        return fincas.stream()
                .sorted(Comparator.comparing(Finca::getSuperficie))
                .toList();
    }

    /**
     * Ordenamos las fincas al contrario y devolvemos las 3 primeras que serían las 3 más grandes.
     * @return
     */
    public static List<Finca> getMasGrandes(){
        return fincas.stream()
                .sorted(Comparator.comparing(Finca::getSuperficie).reversed())
                .limit(3)
                .toList();
    }

    /**
     * Creamos un HashMap, dentro de los paréntesis le pasamos el Stream para agrupar las fincas por ciudad.
     * @return un HashMap con las fincas agrupadas por localidad.
     */
    public static HashMap<String, List<Finca>> getFincasPorCiudad(){
        return new HashMap<>(fincas.stream()
                .collect(Collectors.groupingBy(Finca::getLocalidad)));
    }

    /**
     * Filtramos las fincas que sean mayor que 50 y menor de 150.
     * @return el nombre de las fincas.
     */
    public static List<String> getFincasMedio(){
        return fincas.stream()
               .filter(finca -> finca.getSuperficie() > 50 && finca.getSuperficie() < 150)
               .map(Finca::getNombre)
                .toList();
    }
}
