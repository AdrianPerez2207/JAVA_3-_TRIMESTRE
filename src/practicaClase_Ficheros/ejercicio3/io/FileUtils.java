package practicaClase_Ficheros.ejercicio3.io;

import practicaClase_Ficheros.ejercicio3.models.Categoria;
import practicaClase_Ficheros.ejercicio3.models.Estado;
import practicaClase_Ficheros.ejercicio3.models.Producto2Mano;
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
    //Usuario

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
                StandardOpenOption.WRITE);

        //Generamos todas las líneas
        for (Usuario usuario : usuarios) {
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

    //Producto
    public static List<Producto2Mano> loadProductos() throws IOException {
        Path ficheroProductos = Paths.get("src", "practicaClase_Ficheros", "ejercicio3", "resources", "Productos.csv");
        return Files.lines(ficheroProductos)
                .map(str ->{
                   String[] lineas = str.split(",");

                    //Creamos el objeto Producto.
                    //Long id, String nombre, String descripcion, Categoria categoria, Estado estado, Boolean envio,
                    //                         Double precioVenta
                    return new Producto2Mano(Long.parseLong(lineas[0]), lineas[1], lineas[2], Categoria.valueOf(lineas[3]),
                            Estado.valueOf(lineas[4]), Boolean.valueOf(lineas[5]), Double.parseDouble(lineas[6]));
                })
                .toList();
    }
    public static void guardarProductos(List<Producto2Mano> productos) throws IOException {
        //Abrimos el archivo
        Path ficheroProductos = Paths.get("src", "practicaClase_Ficheros", "ejercicio3", "resources", "Productos.csv");
        BufferedWriter bw = Files.newBufferedWriter(ficheroProductos,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        //Generamos todas las líneas
        for (Producto2Mano producto : productos) {
            StringBuffer sb = new StringBuffer();
            sb.append(producto.getId()).append(",");
            sb.append(producto.getNombre()).append(",");
            sb.append(producto.getDescripcion()).append(",");
            sb.append(producto.getCategoria().toString()).append(",");
            sb.append(producto.getEstado().toString()).append(",");
            sb.append(producto.getEnvio()).append(",");
            sb.append(producto.getPrecioVenta()).append("\n");
            //Escribir líneas en el fichero
            bw.write(sb.toString());
            bw.newLine();
        }
        //Cerramos el BufferedWriter
        bw.close();
    }
}
