package practica1.equipobasket.entidades;

import java.util.HashMap;
import java.util.TreeMap;

public class NBALeague {
    private HashMap<String, EquipoBasket> equipos;
    private TreeMap<String, EquipoBasket> equiposOrdenados;

    public NBALeague() {
        this.equipos = new HashMap<>();
        this.equiposOrdenados = new TreeMap<>();
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
     * Recorremos los equipos, y dentro de los equipos a cada jugador, si la altura
     * de ese jugador es más alta que la del anterior, se guarda su altura y el su información.
     * @return el jugador más alto.
     */
    public JugadorBasket buscarJugadorAlto(){
        JugadorBasket jugadorAlto = null;
        Double alturaMaxima = 0.0;
        for (EquipoBasket equipo : equipos.values()) {
            for (JugadorBasket jugador : equipo.getJugadores()){
                if (jugador.getAltura() > alturaMaxima){
                    alturaMaxima = jugador.getAltura();
                    jugadorAlto = jugador;
                }
            }
        }
        return jugadorAlto;
    }

    /**
     * Buscamos en los equipos y comparamos sus partidos ganados, el que más tenga
     * se guarda su información.
     * @return el equipo con más partidos ganados.
     */
    public EquipoBasket buscarPartidosGanados(){
        Double partidosGanados = 0.0;
        EquipoBasket equipoMasPartidos = null;
        for (EquipoBasket equipo : equipos.values()) {
            if (equipo.getPartidosGanados() > partidosGanados){
                partidosGanados = equipo.getPartidosGanados();
                equipoMasPartidos = equipo;
            }
        }
        return equipoMasPartidos;
    }
}
