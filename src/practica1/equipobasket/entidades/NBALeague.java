package practica1.equipobasket.entidades;

import java.util.*;

public class NBALeague {
    private HashMap<String, EquipoBasket> equipos;
    private TreeMap<String, EquipoBasket> equiposOrdenados;

    public NBALeague() {
        this.equipos = new HashMap<>();
        this.equiposOrdenados = new TreeMap<>();
    }

    public HashMap<String, EquipoBasket> getEquipos() {
        return equipos;
    }

    public TreeMap<String, EquipoBasket> getEquiposOrdenados() {
        return equiposOrdenados;
    }
    //Métodos

    /**
     * Añadimos y eliminamos equipos a cualquier mapa.
     * @param clave
     * @param equipo
     */
    public void addEquipos(String clave, EquipoBasket equipo){
        this.equipos.put(clave, equipo);
        this.equiposOrdenados.put(clave, equipo);
    }
    public void removeEquipos(String clave){
        this.equipos.remove(clave);
        this.equiposOrdenados.remove(clave);
    }

    /**
     * Buscamos equipos por su clave "nombre".
     *
     * @param nombre
     * @return el valor del equipo.
     */
    public EquipoBasket buscarEquiposHash(String nombre){
        return this.equipos.get(nombre);
    }
    public EquipoBasket buscarEquiposTree(String nombre){
        return this.equiposOrdenados.get(nombre);
    }

    /**
     * Mostramos los equipos dentro del HashMap
     */
    public void mostrarEquipos(){
        equipos.forEach((nombre, EquipoBasket) -> {
            System.out.println("Nombre: " + nombre + " / " + " Información: " + EquipoBasket);
        });
    }
    /**
     * Mostramos los equipos dentro del TreeMap
     */
    public void mostrarEquiposOrdenados(){
        equiposOrdenados.forEach((nombre, EquipoBasket) -> {
            System.out.println("Nombre: " + nombre + " / " + " Información: " + EquipoBasket);
        });
    }

    /**
     * Recorremos los equipos, añadimos todos los jugadores a una lista.
     * Con List.sort y unafunción lambda comparamos la altura de los jugadores y devolvemos el primero de la lista.
     * Comparamos al revés ya que añadiría de menor a mayor.
     * @return el jugador más alto.
     */
    public JugadorBasket buscarJugadorAlto(){
        List<JugadorBasket> jugadoresAltos = new ArrayList<>();
        for (String equipo : equipos.keySet()){
            jugadoresAltos.addAll(equipos.get(equipo).getJugadores());
        }
       jugadoresAltos.sort((j1, j2) -> j2.getAltura().compareTo(j1.getAltura()));
        return jugadoresAltos.get(0);
    }

    /**
     * Creamos una lista de Equipos, le añadimos los equipos de la liga.
     * Con List.sort y una función lambda comparamos la altura de los jugadores y devolvemos el primero de la lista.
     * Comparamos al revés ya que añadiría de menor a mayor.
     * @return el equipo con más partidos ganados.
     */
    public EquipoBasket buscarPartidosGanados() {
        List<EquipoBasket> equiposConMasPartidos = new ArrayList<>(this.equiposOrdenados.values());
        equiposConMasPartidos.sort(((e1, e2) -> e2.getPartidosGanados().compareTo(e1.getPartidosGanados())));
        return equiposConMasPartidos.get(0);
    }
}
