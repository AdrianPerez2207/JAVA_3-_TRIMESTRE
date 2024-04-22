package practica2_streams.ejercicio2.entidades;

import java.util.Objects;

public class Ciudad {
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    private Integer poblacion;
    private Pais pais;

    public Ciudad(String nombre, Integer poblacion, Pais pais) {
        this.id = autoincrement++;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return id == ciudad.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
