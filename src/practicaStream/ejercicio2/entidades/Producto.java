package practicaStream.ejercicio2.entidades;

public class Producto {
    public enum CategoriaProducto { LIBROS, JUEGOS, PERIFERICOS }
    private long id;
    private static long autoincrement = 0;
    private String nombre;
    private CategoriaProducto categoria;
    private Double precio;

    public Producto(String nombre, CategoriaProducto categoria, Double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.id = autoincrement++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }
}
