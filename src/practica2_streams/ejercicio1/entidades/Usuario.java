package practica2_streams.ejercicio1.entidades;

import java.util.HashMap;

public class Usuario {
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    private String email;
    private String nick;
    private HashMap<Long , Puntuacion> puntuaciones;

    public Usuario(String nombre, String email, String nick) {
        this.nombre = nombre;
        this.email = email;
        this.nick = nick;
        this.puntuaciones = new HashMap<>();
        this.id = Usuario.autoincrement++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public HashMap<Long, Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Nick: '" + nick + " - "  +
                " email: " + email + " - " +
                '}';
    }
    //Métodos---------------

    /**
     * Comprobamos que el id del Juego exista, si existe comprobamos si ha ganado la partida o perdido
     * Si ha ganado le incrementamos los partidos ganados y le añadimos los puntos, en caso contrario añadimos o restamos puntos
     * Si la id no existe, creamos y añadimos la puntuación.
     * Tenemos que añadir las puntuaciones al mapa
     * @param idJuego
     * @param haGanado
     * @param puntosObtenidos
     */
    public void addPuntuacion(Long idJuego, Boolean haGanado, Integer puntosObtenidos) {
        if (puntuaciones.get(idJuego) == null){
            Puntuacion nuevasPuntuaciones = new Puntuacion();
            puntuaciones.put(idJuego, nuevasPuntuaciones);
            nuevasPuntuaciones.setPartidasGanadas(0);
            nuevasPuntuaciones.setPartidasPerdidas(0);
            nuevasPuntuaciones.setPartidasJugadas(0);
            nuevasPuntuaciones.setPuntos(0);
        }
        Puntuacion puntuacionesRecuperadas = puntuaciones.get(idJuego);
        if (haGanado){
            puntuacionesRecuperadas.setPartidasGanadas(puntuacionesRecuperadas.getPartidasGanadas() + 1);
        } else {
            puntuacionesRecuperadas.setPartidasPerdidas(puntuacionesRecuperadas.getPartidasPerdidas() + 1);
        }
        puntuacionesRecuperadas.setPuntos(puntuacionesRecuperadas.getPuntos() + puntosObtenidos);
        puntuacionesRecuperadas.setPartidasJugadas(puntuacionesRecuperadas.getPartidasJugadas() + 1);
    }

    /**
     * Buscamos el juego con la id
     * @param idJuego
     * @return los puntos si existe, si no, devuelve 0
     */
    public Integer getPuntuacion(Long idJuego){
        if (puntuaciones.containsKey(idJuego)){
            return puntuaciones.get(idJuego).getPuntos();
        } else {
            return 0;
        }
    }
}
