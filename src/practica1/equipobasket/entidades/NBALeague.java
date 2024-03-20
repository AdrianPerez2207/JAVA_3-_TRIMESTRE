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
     * Recorremos los equipos, y dentro de los equipos a cada jugador, si la altura
     * de ese jugador es más alta que la del anterior, se guarda su altura y el su información.
     * Creamos un Array y guardamos la altura y el jugador en el Array.
     * @return el jugador más alto.
     */
    public JugadorBasket buscarJugadorAlto(){
        //Evitar hacer esto
        final JugadorBasket[] jugadorAlto = {null};
        final Double[] alturaMaxima = {0.0};

        equipos.forEach(( nombre , equipo) -> {
            equipo.getJugadores().forEach(jugador -> {
                if (jugador.getAltura() > alturaMaxima[0]){
                    alturaMaxima[0] = jugador.getAltura();
                    jugadorAlto[0] = jugador;
                }
            });
        });
        return jugadorAlto[0];
        /*  Versión 1:
            for(String equipo : equipos.keySet()){
                for(JugadorBasket jugador : equipos.get(equipo).getJugadores()){
                    if(jugador.getAltura() > alturaMaxima){
                        alturaMaxima = jugador.getAltura();
                        jugadorAlto = jugador;
                    }
                }
            } */
        /* Versión 2:
            List<Jugador> jugadores = new ArrayList<>();
            for (String equipo : equipos.keySet()){
                jugadores.addAll(equipos.get(equipo).getJugadores());
            }
            Collections.sort(jugadores, new Comparator<jugador>(){
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o1.getAltura().compareTo(o2);
            }
            } );
            return jugadores.get(0);
         */
        /* Versión 3:
        jugador j1 = null;
        //Ordenan de menor a mayor, si queremos el mayor, comparamos al revés.
            Set<Jugador> jugadores = new TreeSet<>((j1,j2) -> jugador2.queAltura().compareTo(jugador1.getAltura()));
            for (String equipo : equipos.keySet()){
                jugadores.addAll(equipos.get(equipo).getJugadores());
            }
            for(String jugador : jugadores){
                if(jugador.getAltura() > alturaMaxima){
                    jugador1 = jugador;
                    break;
                }
                return jugador1;
            }


         */
    }

    /**
     * Buscamos en los equipos y comparamos sus partidos ganados, el que más tenga
     * se guarda su información.
     * @return el equipo con más partidos ganados.
     */
    public EquipoBasket buscarPartidosGanados(){
        final Double[] partidosGanados = {0.0};
        final EquipoBasket[] equipoMasPartidos = {null};

        equipos.forEach(( nombre , equipo) -> {
            if (equipo.getPartidosGanados() > partidosGanados[0]){
                partidosGanados[0] = equipo.getPartidosGanados();
                equipoMasPartidos[0] = equipo;
            }
        });
        return equipoMasPartidos[0];
    }
}
