package examen_2023.io;

import examen_2023.model.EstacionMeteorologica;
import examen_2023.model.RegistroDatosDia;
import examen_2023.service.ServicioGeneralMeteorologico;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class MeteoFile {
    //que lea el fichero estaciones.csv y las añade dentro de un objeto
    //ServicioGeneralMeteorologico. Luego debe también leer el fichero registros.csv y debe añadir a la
    //estación indicada por el campo “estación” cada registro correspondiente.
    public static ServicioGeneralMeteorologico cargarCSV() throws IOException {
        Path estaciones = Paths.get("src", "examen_2023", "resources", "estaciones.csv");
        ServicioGeneralMeteorologico sgm = new ServicioGeneralMeteorologico();
        Files.lines(estaciones)
                .map(str -> {
                    String[] lines = str.split(",");
                    return new EstacionMeteorologica(Long.parseLong(lines[0]), lines[1], lines[2], Double.parseDouble(lines[3]),
                            Double.parseDouble(lines[4]));
                })
                //Añadimos las estaciones al servicio general meteorologico
                .forEach(sgm::nuevaEstacion);
        /**
         * Leemos el fichero de los registros, dividimos las lineas, en una variable estacionMeteorologica guardamos
         * la estacion que coincida con el id encontrado en el fichero.
         * Le añadimos a la estacion el nuevo registro creado.
         */
        Path registros = Paths.get("src", "examen_2023", "resources", "registros.csv");
        Files.lines(registros)
                .forEach(str -> {
                    String[] lines = str.split(",");
                    EstacionMeteorologica estacionId = sgm.getEstacionPorId(Long.parseLong(lines[5]));
                    estacionId.nuevoRegistro(new RegistroDatosDia(Long.parseLong(lines[0]), LocalDate.parse(lines[1]),
                            Double.parseDouble(lines[2]), Double.parseDouble(lines[3]), Double.parseDouble(lines[4])));
                });
        return sgm;
    }

    public static void guardarCSV(ServicioGeneralMeteorologico sgm) throws IOException {
        //Abrimos el archivo
        Path ficheroEstaciones = Paths.get("src", "examen_2023", "resources", "estaciones.csv");
        Path ficheroRegistros = Paths.get("src", "examen_2023", "resources", "registros.csv");

        //Borramos el fichero, lo creamos y escribimos en él.
        Files.deleteIfExists(ficheroEstaciones);
        BufferedWriter bwEstaciones = Files.newBufferedWriter(ficheroEstaciones,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);
        //Borramos el fichero, lo creamos y escribimos en él.
        Files.deleteIfExists(ficheroRegistros);
        BufferedWriter bwRegistros = Files.newBufferedWriter(ficheroRegistros,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        StringBuffer sbEstacion = new StringBuffer();
        for (EstacionMeteorologica estacion : sgm.getEstaciones()) {
            sbEstacion.append(estacion.getId()).append(",");
            sbEstacion.append(estacion.getNombre()).append(",");
            sbEstacion.append(estacion.getComunidad()).append(",");
            sbEstacion.append(estacion.getLatitud()).append(",");
            sbEstacion.append(estacion.getLongitud()).append("\n");
        }
        bwEstaciones.write(sbEstacion.toString());
        bwEstaciones.close();

        StringBuffer sbRegistro = new StringBuffer();
        for (RegistroDatosDia registros : sgm.getEstaciones().stream()
                .flatMap(estacion -> estacion.getRegistros().stream()).toList()) {
            sbRegistro.append(registros.getId()).append(",");
            sbRegistro.append(registros.getFecha()).append(",");
            sbRegistro.append(registros.getTempMax()).append(",");
            sbRegistro.append(registros.getTempMin()).append(",");
            sbRegistro.append(registros.getTempMedia()).append(",");
            //Para guardar la id de la estacion, entramos en el metodo del Servicio, le pasamos el registro y guardamos
            //solo el id.
            sbRegistro.append(sgm.getEstacionPorRegistro(registros).getId()).append("\n");
        }
        bwRegistros.write(sbRegistro.toString());
        bwRegistros.close();
    }
}
