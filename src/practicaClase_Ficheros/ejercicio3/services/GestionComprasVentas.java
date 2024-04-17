package practicaClase_Ficheros.ejercicio3.services;

import practicaClase_Ficheros.ejercicio3.models.Compra;
import practicaClase_Ficheros.ejercicio3.models.Producto2Mano;
import practicaClase_Ficheros.ejercicio3.models.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestionComprasVentas {

    private Set<VentasUsuario> ventasTotales;
    private List<Compra> comprasTotales;

    public GestionComprasVentas() {
        this.ventasTotales = new HashSet<>();
        this.comprasTotales = new ArrayList<>();
    }

    public Set<VentasUsuario> getVentasTotales() {
        return ventasTotales;
    }

    public List<Compra> getComprasTotales() {
        return comprasTotales;
    }

    @Override
    public String toString() {
        return "GestionComprasVentas{" +
                "ventasTotales=" + ventasTotales +
                ", comprasTotales=" + comprasTotales +
                '}';
    }
    //Métodos.
    public void realizarCompra(Usuario comprador, Producto2Mano producto){
        Compra compra = new Compra(comprador, , producto, LocalDate.now());
        this.comprasTotales.add(compra);
    }
}
