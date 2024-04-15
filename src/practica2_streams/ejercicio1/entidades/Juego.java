package practica2_streams.ejercicio1.entidades;

import java.util.Objects;

public class Juego {
    private long id;
    private static long autoincrementado = 0;
    private String nombre;
    private String plataforma;

    public Juego(String nombre, String plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.id = autoincrementado++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TestVideojuegos{" +
                "nombre" + nombre + " - " +
                " plataforma='" + plataforma + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return id == juego.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
