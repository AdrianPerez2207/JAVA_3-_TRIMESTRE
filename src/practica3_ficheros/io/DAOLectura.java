package practica3_ficheros.io;

import practica3_ficheros.entidades.Finca;
import practica3_ficheros.entidades.Lectura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DAOLectura {

    private static Set<Lectura> lecturas;

    public DAOLectura() throws IOException {
        lecturas = new HashSet<>(cargarDatosLectura());
    }

    public static Set<Lectura> getLecturas() {
        return lecturas;
    }

    /**
     * Leemos el fichero, y creamos un objeto para cada línea, a la lectura le pasamos los atributos, para pasarle
     * una Finca, llamamos al método estático de la clase DAOFInca y buscamos la finca por ID (nos devuelve una Finca).
     * @return
     * @throws IOException
     */

    private static Set<Lectura> cargarDatosLectura() throws IOException {
        Path ficheroLecturas = Paths.get("src", "practica3_ficheros", "resources", "lecturas.csv");
        return Files.lines(ficheroLecturas)
                .map(str -> {
                    String[] lines = str.split(",");

                    return new Lectura(Long.parseLong(lines[0]), Double.parseDouble(lines[1]), Double.parseDouble(lines[2]),
                            LocalDateTime.parse(lines[3]), DAOFinca.findById(Long.parseLong(lines[4])));
                })
                .collect(Collectors.toSet());
    }

    /**
     * Generamos un StringBuffer, con los objetos lectura, y vamos añadiendo línea a línea.
     * Pasamos el StringBuffer a Writer y cerramos el fichero.
     * @throws IOException
     */
    public static void guardarDatos() throws IOException {
        Path ficheroLecturas = Paths.get("src", "practica3_ficheros", "resources", "lecturas.csv");
        BufferedWriter bw = Files.newBufferedWriter(ficheroLecturas,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);
        StringBuffer sb = new StringBuffer();
        for (Lectura lectura : lecturas) {
            sb.append(lectura.getId()).append(",");
            sb.append(lectura.getTemperatura()).append(",");
            sb.append(lectura.getHumedad()).append(",");
            sb.append(lectura.getMomento()).append(",");
            sb.append(lectura.getFinca().getId()).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
    public static void addLectura(Lectura lectura){
        lecturas.add(lectura);
    }
    public static void removeLectura(Lectura lectura){
        lecturas.remove(lectura);
    }
    //Streams---

    /**
     * Creamos un HashMap, hacemos dentro el Stream, agrupamos por fincas.
     * Entramos dentro de las lecturas, en Finca y recogemos el Id de la finca.
     * @return
     */
    public static HashMap<Long, List<Lectura>> getLecturasPorFinca(){
        return new HashMap<>(lecturas.stream()
                .collect(Collectors.groupingBy(lectura -> lectura.getFinca().getId())));
    }

    /**
     * Filtramos las lecturas por el Id de una finca.
     * @param id
     * @return la temperatura máxima de todas las lecturas ed la finca.
     * @throws NoSuchElementException
     */
    public static Double getTempMaximaFinca(Long id)throws NoSuchElementException {
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getId().equals(id))
               .mapToDouble(Lectura::getTemperatura)
               .max()
                .orElseThrow();
    }
    /**
     * Filtramos las lecturas por el Id de una finca.
     * @param id
     * @return la temperatura mínima de todas las lecturas ed la finca.
     * @throws NoSuchElementException
     * */
    public static Double getTempMinimaFinca(Long id)throws NoSuchElementException {
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getId().equals(id))
               .mapToDouble(Lectura::getTemperatura)
               .min()
               .orElseThrow();
    }

    /**
     * Filtramos las lecturas por el Id de una finca.
     * Ordenamos por fecha, despúes nos quedamos con la humedad y la devolvemos.
     * @param id
     * @return
     */
    public static List<Double> getHumedadPorFinca(Long id){
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getId().equals(id))
                .sorted(Comparator.comparing(Lectura::getMomento))
                .map(Lectura::getHumedad)
                .toList();
    }
    /**
     * Filtramos las lecturas por el Id de una finca.
     * Ordenamos por fecha, despúes nos quedamos con la temperatura y la devolvemos.
     * @param id
     * @return
     */
    public static List<Double> getTemperaturaPorFinca(Long id){
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getId().equals(id))
                .sorted(Comparator.comparing(Lectura::getMomento))
                .map(Lectura::getTemperatura)
                .toList();
    }

    /**
     * Filtramos la id y los días.
     * Ordenamos por tiempo.
     * Nos quedamos con las temperaturas.
     * @param id
     * @param dias
     * @return las temperaturas ordenadas por horas.
     */
    public static List<Double> getTempDiaPorFinca(Long id, LocalDate dias){
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getId().equals(id))
               .filter(lectura -> lectura.getMomento().toLocalDate().equals(dias))
                .sorted(Comparator.comparing(lectura -> lectura.getMomento().toLocalTime()))
               .map(Lectura::getTemperatura)
               .toList();
    }
}
