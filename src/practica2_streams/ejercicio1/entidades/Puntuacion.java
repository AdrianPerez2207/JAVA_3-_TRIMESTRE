package practica2_streams.ejercicio1.entidades;

public class Puntuacion {
    private Integer puntos;
    private Integer partidasJugadas;
    private Integer partidasGanadas;
    private Integer partidasPerdidas;

    public Puntuacion() {
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(Integer partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Integer getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Integer partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Integer getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(Integer partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    @Override
    public String toString() {
        return "Puntuacion{" +
                "Puntos: " + puntos + " - " +
                " PJ: " + partidasJugadas + " - " +
                " PG: " + partidasGanadas + " - " +
                " PP: " + partidasPerdidas + " - " +
                '}';
    }
}
