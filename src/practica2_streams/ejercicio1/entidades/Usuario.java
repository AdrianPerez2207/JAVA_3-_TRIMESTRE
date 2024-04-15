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
     * Si ha ganado le incrementamos los partidos ganados y le añadimos los putos, en caso contrario añadimos o restamos puntos
     * Si la id no existe, creamos y añadimos la puntuación.
     * @param idJuego
     * @param haGanado
     * @param puntosObtenidos
     */
    public void addPuntuacion(Long idJuego, Boolean haGanado, Integer puntosObtenidos) {
        if (puntuaciones.containsKey(idJuego)){
            Puntuacion values = puntuaciones.get(idJuego);
            if (haGanado){
                values.setPartidasGanadas(values.getPartidasGanadas() + 1);
            } else {
                values.setPartidasPerdidas(values.getPartidasPerdidas() + 1);
            }
            values.setPartidasJugadas(values.getPartidasJugadas() + 1);
            values.setPuntos(values.getPuntos() + puntosObtenidos);
        } else {
            Puntuacion puntuacionObtenida = new Puntuacion();
            puntuacionObtenida.setPartidasJugadas(puntuacionObtenida.getPartidasJugadas() + 1);
            if (haGanado){
                puntuacionObtenida.setPartidasGanadas(puntuacionObtenida.getPartidasGanadas() + 1);
            } else {
                puntuacionObtenida.setPartidasPerdidas(puntuacionObtenida.getPartidasPerdidas() + 1);
            }
            puntuacionObtenida.setPuntos(puntuacionObtenida.getPuntos() + puntosObtenidos);
        }
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
