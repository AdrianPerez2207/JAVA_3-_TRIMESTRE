package practica2_streams.ejercicio1.servicios;

import practica2_streams.ejercicio1.entidades.*;

import java.util.*;

public class Steam {
    private ArrayList<Juego> juegos;
    private LinkedList<Usuario> jugadores;

    public Steam() {
        juegos = new ArrayList<>();
        jugadores = new LinkedList<>();
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public LinkedList<Usuario> getJugadores() {
        return jugadores;
    }
    //Métodos-----------
    public void addJuego(Juego juego) {
        juegos.add(juego);
    }
    public void delJuego(Juego juego){
        juegos.remove(juego);
    }
    public void addUsuario(Usuario usuario) {
        jugadores.add(usuario);
    }
    public void delUsuario(Usuario usuario){
        jugadores.remove(usuario);
    }

    /**
     * Listamos todos los jugadores de Steam.
     * @return la lista de los jugadores.
     */
    public String listarJugadores(){
        StringBuffer listaJugadores = new StringBuffer();
        for (Usuario usuario : jugadores) {
            listaJugadores.append(usuario).append("\n");
        }
        return listaJugadores.toString();
    }
    /**
     * Listamos todos los juegos de Steam.
     * @return la lista de los juegos.
     */
    public String listarJuegos(){
        StringBuffer listaJuegos = new StringBuffer();
        for (Juego juego : juegos) {
            listaJuegos.append(juego).append("\n");
        }
        return listaJuegos.toString();
    }

    /**
     * Comparamos los puntos, filtramos el juego que contenga la id, luego nos quedamos
     * con las puntuaciones y las guardamos.
     * @param idJuego
     * @return las puntuaciones ordenadas.
     */
    public TreeSet<Puntuacion> obtenerPuntuaciones(Long idJuego){
        TreeSet<Puntuacion> puntuacionesOrdenadas = new TreeSet<>(new Comparator<Puntuacion>() {
            @Override
            public int compare(Puntuacion o1, Puntuacion o2) {
                return o1.getPuntos().compareTo(o2.getPuntos());
            }
        });
        jugadores.stream()
                .filter(usuario -> usuario.getPuntuaciones().containsKey(idJuego))
                .map(usuario -> usuario.getPuntuaciones().get(idJuego))
                .forEach(puntuacionesOrdenadas::add);
        return puntuacionesOrdenadas;
    }

    /**
     * Filtramos el usuario, nos quedamos con la puntuación del juego indicado,
     * Si lo encuentra y está presente lo pinta.
     * @param idJuego
     * @param idUsuario
     */
    public void buscarPuntuacion(Long idJuego, Long idUsuario){
        jugadores.stream()
                .filter(usuario -> usuario.getId() == idUsuario)
                .map(usuario -> usuario.getPuntuaciones().get(idJuego))
                .findAny()
                .ifPresent(System.out::println);
    }

    /**
     * Pintamos el juego, buscamos el usuario que juege a ese juego, ordenadmos sus puntos,
     * pintamos el nick del usuario y las puntuaciones en ese juego con formato printf.
     */
    public void pintarRankingJuegos(){
        juegos.forEach(juego -> {System.out.println("Nombre: " + juego.getNombre());
                jugadores.stream()
                        .filter(usuario -> usuario.getPuntuaciones().containsKey(juego.getId()))
                        .sorted(Comparator.comparing(usuario -> usuario.getPuntuacion(juego.getId())))
                        .forEach(usuario -> System.out.printf("Nick: %s - Puntuación: %d", usuario.getNick(),
                                usuario.getPuntuacion(juego.getId())));
        });
    }
}
