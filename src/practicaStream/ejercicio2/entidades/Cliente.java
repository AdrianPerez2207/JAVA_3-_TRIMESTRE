package practicaStream.ejercicio2.entidades;

public class Cliente {
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    private Integer nivel;

    public Cliente(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.id = autoincrement++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
