package practicaClase_Ficheros.ejercicio2.io;

import practicaClase_Ficheros.ejercicio2.models.Gamer;
import practicaClase_Ficheros.ejercicio2.models.Levels;
import practicaClase_Ficheros.ejercicio2.services.Discord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DAOGamer {

    public static List<Gamer> loadGamers() throws IOException {
        //Fichero a leer
        Path fileGamers = Paths.get("src","practicaClase_Ficheros", "ejercicio2", "resources", "gamers.csv");
        return Files.lines(fileGamers)
                .map(str ->{
                    String[] cad = str.split(",");

                    //Create object Gamer

                    return new Gamer(Long.parseLong(cad[0]), cad[1], cad[2], cad[3], Levels.valueOf(cad[4]));
                })
                .toList();



    }

    public static void saveGamers(List<Gamer> gamers) throws IOException {
        //Open the file gamers.csv
        Path fileGamers = Paths.get("practicaClase_Ficheros/ejercicio2", "resources", "gamers.csv");
        BufferedWriter bw = Files.newBufferedWriter(fileGamers,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        //gamers.stream()
        //        .forEach(gamer ->{
                    //ForEach gamer genera un String por línea
        for(Gamer gamer : gamers){
            StringBuffer sb = new StringBuffer();
            sb.append(gamer.getId()).append(",");
            sb.append(gamer.getNick()).append(",");
            sb.append(gamer.getEmail()).append(",");
            sb.append(gamer.getJuego()).append(",");
            sb.append(gamer.getNivel()).append(",");

            //Escribe líneas en el fichero gamers.csv
            bw.write(sb.toString());
            bw.newLine();
        }
        //Close the BuffereWriter
        bw.close();
    }


}
