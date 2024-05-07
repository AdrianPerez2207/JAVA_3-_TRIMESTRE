package examen2.io;

import examen2.entities.Hotel;
import examen2.entities.HotelPlaya;
import examen2.entities.HotelRural;
import examen2.entities.Reserva;
import examen2.services.Booking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public static void grabarCSV(Booking booking) throws IOException {

        Path fileHoteles = Paths.get("src", "examen2", "resources", "hoteles.csv");
        Path fileReservas = Paths.get("src", "examen2", "resources", "reservas.csv");

        Files.deleteIfExists(fileHoteles);
        BufferedWriter bwHotel = Files.newBufferedWriter(fileHoteles,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        StringBuffer sbHotel = new StringBuffer();
        for (Hotel hotel : booking.getHoteles()){
            if (hotel instanceof HotelRural){
                HotelRural hr = (HotelRural) hotel;
                sbHotel.append(hr.getNombre()).append(",");
                sbHotel.append(hr.getDireccion()).append(",");
                sbHotel.append(hr.getLocalidad()).append(",");
                sbHotel.append(hr.getProvincia()).append(",");
                sbHotel.append(hr.getNumHabitaciones()).append(",");
                sbHotel.append(hr.getPrecioNoche()).append(",");
                sbHotel.append(hr.getCalificacion()).append(",");
                sbHotel.append(1).append(",");
                sbHotel.append(hr.getCalefaccion()).append(",");
                sbHotel. append(0).append("\n"); //Cómo los hoteles rurales no tienen aire le ponemos 0
            } else {
                HotelPlaya hp = (HotelPlaya) hotel;
                sbHotel.append(hp.getNombre()).append(",");
                sbHotel.append(hp.getDireccion()).append(",");
                sbHotel.append(hp.getLocalidad()).append(",");
                sbHotel.append(hp.getProvincia()).append(",");
                sbHotel.append(hp.getNumHabitaciones()).append(",");
                sbHotel.append(hp.getPrecioNoche()).append(",");
                sbHotel.append(hp.getCalificacion()).append(",");
                sbHotel.append(0).append(",");
                sbHotel.append(0).append(",");
                sbHotel.append(hp.getAireAcondicionado()).append("\n");
            }
        }

        bwHotel.write(sbHotel.toString());
        bwHotel.close();


        Files.deleteIfExists(fileReservas);
        BufferedWriter bwReservas = Files.newBufferedWriter(fileReservas,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);

        StringBuffer sbReservas = new StringBuffer();
        for (Reserva reserva : booking.getReservas()){
            sbReservas.append(reserva.getFechaEntrada()).append(",");
            sbReservas.append(reserva.getFechaSalida()).append(",");
            sbReservas.append(reserva.getNumHabitaciones()).append(",");
            sbReservas.append(reserva.getPersonasHabitacion()).append(",");
            sbReservas.append(reserva.getDni()).append(",");
            sbReservas.append(reserva.getNacionalidad()).append(",");
            sbReservas.append(reserva.getHotel().getId()).append("\n");
        }

        bwReservas.write(sbReservas.toString());
        bwReservas.close();
    }


}
