package practica3_ficheros.entidades;

import java.util.Objects;

public class Finca {

    private Long id;
    private String nombre;
    private Double longitud;
    private Double latitud;
    private Double superficie;
    private String localidad;
    private String provincia;

    public Finca() {
    }

    public Finca(Long id, String nombre, Double longitud, Double latitud, Double superficie, String localidad, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.superficie = superficie;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Finca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Longitud=" + longitud +
                ", latitud=" + latitud +
                ", superficie=" + superficie +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finca finca = (Finca) o;
        return Objects.equals(id, finca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
