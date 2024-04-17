package practicaClase_Ficheros.ejercicio3.services;

import practicaClase_Ficheros.ejercicio3.models.Compra;
import practicaClase_Ficheros.ejercicio3.models.Producto2Mano;
import practicaClase_Ficheros.ejercicio3.models.Usuario;

import java.util.*;

public class PerfilUsuario {
    private Usuario usuario;
    private Set<Producto2Mano> productosDisponibles;
    private ArrayList<Compra> ventas;
    private ArrayList<Compra> comprasRealizadas;

    public PerfilUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.productosDisponibles = new HashSet<>();
        this.ventas = new ArrayList<>();
        this.comprasRealizadas = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Producto2Mano> getProductosDisponibles() {
        return productosDisponibles;
    }

    public ArrayList<Compra> getVentas() {
        return ventas;
    }

    public ArrayList<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }

    @Override
    public String toString() {
        return "VentasUsuario{" +
                "usuario=" + usuario.getLogin() +
                ", productosDisponibles=" + productosDisponibles +
                ", ventas=" + ventas +
                ", comprasRealizadas=" + comprasRealizadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilUsuario that = (PerfilUsuario) o;
        return Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }
    //Métodos.

    /**
     * Agregamos productos a los disponibles
     * @param producto
     */
    public void agregarProducto(Producto2Mano producto){
        this.productosDisponibles.add(producto);
    }

    /**
     * Eliminamos productos de los disponibles
     * @param producto
     */
    public void eliminarProducto(Producto2Mano producto){
        this.productosDisponibles.remove(producto);
    }

    /**
     * Agregamos una venta
     * @param venta
     */
    public void agregarVenta(Compra venta){
        this.ventas.add(venta);
    }
    /**
     * Eliminamos una venta
     * @param venta
     */
    public void eliminarVenta(Compra venta){
        this.ventas.remove(venta);
    }
    /**
     * Agregamos una compra realizada
     * @param compra
     */
    public void agregarCompra(Compra compra){
        this.comprasRealizadas.add(compra);
    }
    /**
     * Eliminamos una compra
     * @param compra
     */
    public void eliminarCompra(Compra compra){
        this.comprasRealizadas.remove(compra);
    }

    /**
     * Mostramos las ventas del Usuario
     */
    public void listarVentas(){
        this.ventas.forEach(System.out::println);
    }
    /**
     * Mostramos las compras del Usuario
     */
    public void listarCompras(){
        this.comprasRealizadas.forEach(System.out::println);
    }
}
