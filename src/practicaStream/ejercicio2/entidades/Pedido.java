package practicaStream.ejercicio2.entidades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
    public enum EstadoProducto { RECIBIDO, PROCESADO, ENVIADO }
    private long id;
    private static long autoincrement = 0;
    private LocalDate fechaPedido;
    private LocalDate fechaEnvio;
    private EstadoProducto estado;
    private Cliente cliente;
    private Set<Producto> productos;

    public Pedido(LocalDate fechaPedido, LocalDate fechaEnvio, EstadoProducto estado, Cliente cliente) {
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = new HashSet<>();
        this.id = autoincrement++;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public Set<Producto> getProductos() {
        return productos;
    }
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fechaPedido=" + fechaPedido +
                ", fechaEnvio=" + fechaEnvio +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}
