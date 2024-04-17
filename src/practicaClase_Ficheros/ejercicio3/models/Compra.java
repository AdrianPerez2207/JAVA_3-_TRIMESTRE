package practicaClase_Ficheros.ejercicio3.models;

import java.time.LocalDate;

public class Compra {
    private Usuario usuarioCompra;
    private Usuario usuarioVende;
    private Producto2Mano producto;
    private LocalDate fecha;
    private Double precioCompra; //(puede ser inferior al precio de venta del
                                //producto, pero no superior


    public Compra(Usuario usuarioCompra, Usuario usuarioVende, Producto2Mano producto, LocalDate fecha, Double precioCompra) {
        this.usuarioCompra = usuarioCompra;
        this.usuarioVende = usuarioVende;
        this.producto = producto;
        this.fecha = fecha;
        this.precioCompra = precioCompra;
    }

    public Usuario getUsuarioCompra() {
        return usuarioCompra;
    }

    public void setUsuarioCompra(Usuario usuarioCompra) {
        this.usuarioCompra = usuarioCompra;
    }

    public Usuario getUsuarioVende() {
        return usuarioVende;
    }

    public void setUsuarioVende(Usuario usuarioVende) {
        this.usuarioVende = usuarioVende;
    }

    public Producto2Mano getProducto() {
        return producto;
    }

    public void setProducto(Producto2Mano producto) {
        this.producto = producto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "usuarioCompra=" + usuarioCompra.getLogin() +
                ", usuarioVende=" + usuarioVende.getLogin() +
                ", producto=" + producto.getNombre() +
                ", fecha=" + fecha +
                ", precioCompra=" + precioCompra +
                '}';
    }
}
