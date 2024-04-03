package practicaStream.ejercicio1.entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Pelicula {
    private long id;
    private static long autoincrement = 0;
    private String titulo;
    private Integer anio;
    private ArrayList<Genero> generos;
    private ArrayList<Director> directores;

    public Pelicula(String titulo, Integer anio) {
        this.titulo = titulo;
        this.anio = anio;
        this.id = autoincrement++;
        this.generos = new ArrayList<>();
        this.directores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public long getId() {
        return id;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public ArrayList<Director> getDirectores() {
        return directores;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pelicula{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", anio=").append(anio);
        sb.append(", generos=").append(generos);
        sb.append(", directores=").append(directores);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public void addGenero(Genero genero) {
        this.generos.add(genero);
    }
    public void deleteGenero(Genero genero) {
        this.generos.remove(genero);
    }
    public void addDirector(Director director) {
        this.directores.add(director);
    }
    public void deleteDirector(Director director) {
        this.directores.remove(director);
    }
}
