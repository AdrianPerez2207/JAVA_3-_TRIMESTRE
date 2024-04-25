package examen_2023.service;

import examen_2023.model.EstacionMeteorologica;
import examen_2023.model.RegistroDatosDia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioGeneralMeteorologico {

    private ArrayList<EstacionMeteorologica> estaciones;

    public ServicioGeneralMeteorologico() {
        this.estaciones = new ArrayList<>();
    }

    public ArrayList<EstacionMeteorologica> getEstaciones() {
        return estaciones;
    }

    @Override
    public String toString() {
        return "ServicioGeneralMeteorologico{" +
                "estaciones=" + estaciones +
                '}';
    }

    //Métodos-----
    public void nuevaEstacion(EstacionMeteorologica estacion){
        this.estaciones.add(estacion);
    }
    public void eliminarEstacion(EstacionMeteorologica estacion){
        this.estaciones.remove(estacion);
    }

    /**
     * Buscamos las estaciones que coincidan con el nombre pasado por parámetro.
     * @param nombre
     */
    public void buscarEstacion(String nombre){
        estaciones.stream()
                .filter(estacion -> estacion.getNombre().equals(nombre))
                .forEach(System.out::println);
    }

    /**
     * Filtramos las estaciones que coinciden con el id.
     * Con FlatMap nos quedamos con un stream de los registros y filtramos por año.
     * @param id
     * @param anio
     * @return los registros de ese año pasados a lista.
     */
    public List<RegistroDatosDia> getTempPorAnioEstacion(Long id, Integer anio){
        return estaciones.stream()
               .filter(estacion -> estacion.getId().equals(id))
                .flatMap(estacion -> estacion.getRegistros().stream())
                .filter(registro -> registro.getFecha().getYear() == anio)
                .toList();
    }
}
