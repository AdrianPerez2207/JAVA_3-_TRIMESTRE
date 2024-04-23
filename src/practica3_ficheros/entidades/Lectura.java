package practica3_ficheros.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lectura {

    private Long id;
    private Double temperatura;
    private Double humedad;
    private LocalDateTime momento;
    private Finca finca;

    public Lectura() {
    }

    public Lectura(Long id, Double temperatura, Double humedad, LocalDateTime momento, Finca finca) {
        this.id = id;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.momento = momento;
        this.finca = finca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "id=" + id +
                ", temperatura=" + temperatura +
                ", humedad=" + humedad +
                ", momento=" + momento +
                ", finca=" + finca +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lectura lectura = (Lectura) o;
        return Objects.equals(id, lectura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
