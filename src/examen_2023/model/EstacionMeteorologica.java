package examen_2023.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class EstacionMeteorologica {

    private Long id;
    private String nombre;
    private String comunidad;
    private Double latitud;
    private Double longitud;
    private TreeSet<RegistroDatosDia> registros;

    public EstacionMeteorologica() {
    }

    public EstacionMeteorologica(Long id, String nombre, String comunidad, Double latitud, Double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.latitud = latitud;
        this.longitud = longitud;
        registros = new TreeSet<>();
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

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public TreeSet<RegistroDatosDia> getRegistros() {
        return registros;
    }

    @Override
    public String toString() {
        return "EstacionMeteorologica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", comunidad='" + comunidad + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", registros=" + registros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacionMeteorologica that = (EstacionMeteorologica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Métodos-----------
    public void nuevoRegistro(RegistroDatosDia registro){
        this.registros.add(registro);
    }
    public void eliminarRegistros(RegistroDatosDia registro){
        this.registros.remove(registro);
    }

    /**
     * Buscamos todos los registros que coincidan cone esa fecha.
     * @param fecha
     * @return los devolvemos pasados a lista.
     */
    public List<RegistroDatosDia> buscarRegistro(LocalDate fecha) {
        return registros.stream()
                .filter(registro -> registro.getFecha().equals(fecha))
                .toList();
    }
}
