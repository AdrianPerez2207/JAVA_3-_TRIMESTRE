package examen2.app;

import examen2.io.DAOReservas;
import examen2.services.Booking;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        Booking booking = DAOReservas.cargarCSV();

        System.out.println(booking.getHoteles());



    }
}
