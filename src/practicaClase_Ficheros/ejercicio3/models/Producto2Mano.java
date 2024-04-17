package practicaClase_Ficheros.ejercicio3.models;

import java.util.Objects;

public class Producto2Mano {
    private Long id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private Boolean envio;
    private Double precioVenta;
    private Usuario usuario;

    public Producto2Mano(Long id, String nombre, String descripcion, Categoria categoria, Estado estado, Boolean envio,
                         Double precioVenta, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.envio = envio;
        this.precioVenta = precioVenta;
        this.usuario = usuario;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getEnvio() {
        return envio;
    }

    public void setEnvio(Boolean envio) {
        this.envio = envio;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precio) {
        this.precioVenta = precio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Producto2Mano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", estado=" + estado +
                ", envio=" + envio +
                ", precio=" + precioVenta +
                ", usuario=" + usuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto2Mano that = (Producto2Mano) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
