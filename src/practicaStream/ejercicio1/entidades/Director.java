package practicaStream.ejercicio1.entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Director {
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    //private ArrayList<Pelicula> peliculas;

    public Director(String nombre) {
        this.nombre = nombre;
        //this.peliculas = new ArrayList<>();
        this.id = Director.autoincrement++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //public ArrayList<Pelicula> getPeliculas() {
    //    return peliculas;
    //}

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Director{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        //sb.append(", peliculas=").append(peliculas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(id, director.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //public void addPelicula(Pelicula pelicula) {
    //    this.peliculas.add(pelicula);
    //    pelicula.addDirector(this);
    //}
    //public void deletePelicula(Pelicula pelicula) {
    //    this.peliculas.remove(pelicula);
    //    pelicula.deleteDirector(this);
    //}
}
