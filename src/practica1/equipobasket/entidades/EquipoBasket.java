package practica1.equipobasket.entidades;

import java.util.*;

public class EquipoBasket {
    private String nombre;
    private Double partidosGanados;
    private Double partidosPerdidos;
    private HashSet<JugadorBasket> jugadores;

    public EquipoBasket(String nombre, Double partidosGanados, Double partidosPerdidos) {
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.jugadores = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(Double partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Double getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(Double partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public HashSet<JugadorBasket> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "EquipoBasket{" +
                "nombre='" + nombre + '\'' +
                ", partidosGanados=" + partidosGanados +
                ", partidosPerdidos=" + partidosPerdidos +
                ", jugadores=" + jugadores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipoBasket that = (EquipoBasket) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    //Métodos

    /**
     * Añadimos y borramos jugadores del equipo
     * @param jugador
     */
    public void addJugador(JugadorBasket jugador){
        this.jugadores.add(jugador);
    }
    public void removeJugador(JugadorBasket jugador){
        this.jugadores.remove(jugador);
    }

    /**
     *Añadimos a una cadena el nombre y el jugador del equipo.
     * @return el nombre y dorsal de los jugadores del equipo.
     */
    public String mostrarEquipo(){
        StringBuffer sb = new StringBuffer();
        jugadores.forEach(jugadorBasket -> sb.append("Jugador : ").append(jugadorBasket.getNombre()).append("Dorsal: ")
                .append(jugadorBasket.getDorsal()).append("\n"));
        return sb.toString();
    }

    /**
     * Buscamos en el equipo el dorsal pasado por parámetro.
     * @param dorsal
     * @return el jugador.
     */
    public JugadorBasket buscarJugadore(Integer dorsal){
        for(JugadorBasket jugadorBasket: jugadores){
            if(jugadorBasket.getDorsal() == dorsal){
                return jugadorBasket;
            }
        }
        return null;
    }

    /**
     * Pasamos todos los jugadores a una nueva lista, los ordenamos, buscamos su posición y guardamos la posición.
     * @param nombre
     * @return el jugador que coincida con el nombre pasado por parámetro.
     */
    public JugadorBasket buscarJugador(String nombre){
        ArrayList<JugadorBasket> jugadoresOrdenados = new ArrayList<JugadorBasket>(jugadores);

         //Implementamos la interfaz comparator, comparamos que los jugadores coincidan.

        jugadoresOrdenados.sort(new Comparator<JugadorBasket>() {
            @Override
            public int compare(JugadorBasket o1, JugadorBasket o2) {
                return o1.compareTo(o2);
            }
        });
        //Buscamos con binarySearch y guardamos la posición del jugador.
        Integer encontrado = Collections.binarySearch(jugadoresOrdenados, new JugadorBasket(nombre));
        return jugadoresOrdenados.get(encontrado);
    }
}
