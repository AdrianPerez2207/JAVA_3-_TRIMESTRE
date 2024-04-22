package practica2_streams.ejercicio2.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pais {
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    private Continente continente;
    private Double superficie;
    private Integer poblacion;
    private Ciudad capital;
    private List<Ciudad> ciudades;

    public Pais(String nombre, Continente continente, Double superficie, Integer poblacion) {
        this.id = autoincrement++;
        this.nombre = nombre;
        this.continente = continente;
        this.superficie = superficie;
        this.poblacion = poblacion;
        this.ciudades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public Ciudad getCapital() {
        return capital;
    }

    public void setCapital(Ciudad capital) {
        this.capital = capital;
    }

    public long getId() {
        return id;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", continente=" + continente +
                ", superficie=" + superficie +
                ", poblacion=" + poblacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return id == pais.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //Métodos
    public void addCiudad(Ciudad ciudad) {
        this.ciudades.add(ciudad);
    }
    public void deleteCiudad(Ciudad ciudad){
        this.ciudades.remove(ciudad);
    }
}
