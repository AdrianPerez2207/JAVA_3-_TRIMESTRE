package practicaStream.ejercicio1.entidades;

import java.util.Objects;

public class Genero {

    private long id;
    private static long autoincrement = 0;
    private String nombre;

    public Genero(String nombre) {
        this.id = Genero.autoincrement++;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Genero{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
