package IntroduccionStream.entidades;

import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime fechaHora;
    private Double temperatura;
    private Double humedad;

    public Registro(LocalDateTime fechaHora, Double temperatura, Double humedad) {
        this.fechaHora = fechaHora;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "fechaHora=" + fechaHora +
                ", temperatura=" + temperatura +
                ", humedad=" + humedad +
                '}';
    }
}
