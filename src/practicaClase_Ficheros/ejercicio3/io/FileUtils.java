package practicaClase_Ficheros.ejercicio3.io;

import practicaClase_Ficheros.ejercicio3.models.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public class FileUtils {

    public static List<Usuario> loadUsuarios() throws IOException {
        Path ficheroUsuarios = Paths.get("src", "practicaClase_Ficheros", "ejercicio3", "resources", "Usuario.csv");
        return Files.lines(ficheroUsuarios)
                .map(str ->{
                    String[] lineas = str.split(",");

                    //Creamos el objeto Usuario.
                    return new Usuario(lineas[0], lineas[1], lineas[2], lineas[3], LocalDate.parse(lineas[4]), lineas[5], lineas[6]);
                })
                .toList();
    }
    public static void guardarUsuarios(List<Usuario> usuarios) throws IOException {
        //Abrimos el archivo
        Path ficheroUsuarios = Paths.get("src", "practicaClase_Ficheros", "ejercicio3", "resources", "Usuario.csv");
        BufferedWriter bw = Files.newBufferedWriter(ficheroUsuarios,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.APPEND);

        //Generamos todas las líneas
        for(Usuario usuario : usuarios){
            StringBuffer sb = new StringBuffer();
            sb.append(usuario.getNombre()).append(",");
            sb.append(usuario.getApellidos()).append(",");
            sb.append(usuario.getGenero()).append(",");
            sb.append(usuario.getDni()).append(",");
            sb.append(usuario.getFechaNacimiento()).append(",");
            sb.append(usuario.getLogin()).append(",");
            sb.append(usuario.getPassword()).append("\n");
            //Escribir líneas en el fichero
            bw.write(sb.toString());
            bw.newLine();
        }
        //Cerramos el BufferedWriter
        bw.close();
    }
}
