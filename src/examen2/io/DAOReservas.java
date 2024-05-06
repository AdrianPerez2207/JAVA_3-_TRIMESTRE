package examen2.io;

import examen2.entities.Hotel;
import examen2.entities.HotelPlaya;
import examen2.entities.HotelRural;
import examen2.entities.Reserva;
import examen2.services.Booking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DAOReservas {

    public static Booking cargarCSV() throws IOException {

        Path fileHoteles = Paths.get("src", "examen2", "resources", "hoteles.csv");
        Path fileReservas = Paths.get("src", "examen2", "resources", "reservas.csv");

        Booking book = new Booking();

        Files.lines(fileHoteles)
                .map(str ->{
                     String[] cad = str.split(",");
                     //Create object Hotel
                    Integer tipoHotel = Integer.parseInt(cad[7]);
                    if (tipoHotel == 1){
                        HotelRural hr = new HotelRural(cad[0], cad[1], cad[2], cad[3],
                                Integer.parseInt(cad[4]), Double.parseDouble(cad[5]), Integer.parseInt(cad[6]),
                                Boolean.parseBoolean(cad[8]));
                        return hr;
                    } else {
                        HotelPlaya hp = new HotelPlaya(cad[0], cad[1], cad[2], cad[3],
                                Integer.parseInt(cad[4]), Double.parseDouble(cad[5]), Integer.parseInt(cad[6]),
                                //hote rural tiene calefaccion[8] y hotel playa aire acondicionado[9].
                                //Aire acondicionado es el 9.
                                Boolean.parseBoolean(cad[9]));
                        return hp;
                    }
                 })
                .forEach(book::addHotel);

        Set<Reserva> reservas = Files.lines(fileReservas)
                .map(str ->{
                     String[] cad = str.split(",");
                     //Create object Reserva
                     return new Reserva(LocalDate.parse(cad[0]), LocalDate.parse(cad[1]),
                             Integer.parseInt(cad[2]), Integer.parseInt(cad[3]), cad[4], cad[5],
                             book.findById(Long.parseLong(cad[6])));
                 })
                .collect(Collectors.toSet());
        book.setReservas(reservas);
        return book;
    }
}
