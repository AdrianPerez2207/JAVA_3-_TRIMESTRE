package examen_2023.model;

import java.time.LocalDate;
import java.util.Objects;

public class RegistroDatosDia implements Comparable<RegistroDatosDia>{

    private Long id;
    private LocalDate fecha;
    private Double tempMax;
    private Double tempMin;
    private Double tempMedia;

    public RegistroDatosDia() {
    }

    public RegistroDatosDia(Long id, LocalDate fecha, Double tempMax, Double tempMin, Double tempMedia) {
        this.id = id;
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.tempMedia = tempMedia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMedia() {
        return tempMedia;
    }

    public void setTempMedia(Double tempMedia) {
        this.tempMedia = tempMedia;
    }

    @Override
    public String toString() {
        return "RegistroDatosDia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", tempMedia=" + tempMedia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroDatosDia that = (RegistroDatosDia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(RegistroDatosDia o) {
        return this.getFecha().compareTo(o.getFecha());
    }
}
