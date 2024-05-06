package examen2.services;

import examen2.entities.Hotel;
import examen2.entities.HotelPlaya;
import examen2.entities.Reserva;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Booking {

    private List<Hotel> hoteles;
    private Set<Reserva> reservas;

    public Booking() {
        this.hoteles = new ArrayList<>();
        this.reservas = new HashSet<>();
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addHotel(Hotel hotel){
        this.hoteles.add(hotel);
    }
    public void removeHotel(Hotel hotel){
        this.hoteles.remove(hotel);
    }

    public void addReserva2(LocalDate fechaEntrada, LocalDate fechaSalida, Integer numHabitaciones, Integer personasHabitacion,
                           String dni, String nacionalidad, Hotel hotel){
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, numHabitaciones, personasHabitacion, dni, nacionalidad, hotel);
        this.reservas.add(reserva);
    }
    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void removeReserva(Long id){
        this.reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public Hotel findById(Long idHotel){
        return hoteles.stream()
               .filter(h -> h.getId().equals(idHotel))
               .findFirst()
               .orElseThrow();
    }
    public Reserva findReservasById(long id){
        return this.reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Hotel> findHotelByProvincia(String provincia){
        return this.hoteles.stream()
                .filter(h -> h.getProvincia().equals(provincia))
                .toList();
    }

    public List<Hotel> getHotelesMini(){
        return this.hoteles.stream()
                .filter(h -> h.getNumHabitaciones() < 20)
                .sorted(Comparator.comparing(Hotel::getPrecioNoche).reversed())
                .toList();
    }

    public List<Hotel> hotelesCaros(){
        return this.hoteles.stream()
                .sorted(Comparator.comparing(Hotel::getPrecioNoche).reversed())
                .limit(2)
                .toList();
    }

    public HashMap<String, List<Hotel>> getHotelesLocalidad(){
        return (HashMap<String, List<Hotel>>) this.hoteles.stream()
                .collect(Collectors.groupingBy(Hotel::getLocalidad));
    }

    public HashMap<String, List<Hotel>> getHotelesLocalidad2(){
        HashMap<String, List<Hotel>> hotelesAgrupados = (HashMap<String, List<Hotel>>) this.hoteles.stream()
                .collect(Collectors.groupingBy(Hotel::getLocalidad));

        hotelesAgrupados.forEach((k, v) -> {
            v.sort(Comparator.comparing(Hotel::getPrecioNoche).reversed());
        });

        return hotelesAgrupados;
    }

    public Set<Hotel> getHotelesPlaya(){
        return this.hoteles.stream()
                .filter(h -> h instanceof HotelPlaya) //Rompe la POO
                .collect(Collectors.toSet());
    }

    public HashMap<String, Long> getReservasNacionalidad(){
        return (HashMap<String, Long>) this.reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getNacionalidad, Collectors.counting()));
    }

    public Double getImporteReserva(Long idReserva){
        Reserva reserva = this.findReservasById(idReserva);
        Integer numDias = Period.between(reserva.getFechaEntrada(), reserva.getFechaSalida()).getDays();
        return reserva.getNumHabitaciones() * reserva.getHotel().getPrecioNoche() * numDias;
    }

    public List<Reserva> getReservasActivas(Long idHotel){
        return this.reservas.stream()
                .filter(r -> r.getHotel().getId().equals(idHotel))
                .filter(r -> r.getFechaEntrada().isBefore(LocalDate.now()) ||
                        r.getFechaEntrada().equals(LocalDate.now()))
                .filter(r -> r.getFechaSalida().isAfter(LocalDate.now()) ||
                        r.getFechaSalida().equals(LocalDate.now()))
                .toList();
    }

    public Double getImporteReservasFinalizadas(Long idHotel){
        return reservas.stream()
                .filter(r -> r.getHotel().getId().equals(idHotel))
                .filter(r -> r.getFechaSalida().isBefore(LocalDate.now()))
                .mapToDouble(r -> {
                     Integer numDias = Period.between(r.getFechaEntrada(), r.getFechaSalida()).getDays();
                     return r.getNumHabitaciones() * r.getHotel().getPrecioNoche() * numDias;
                })
                .sum();
    }
}
