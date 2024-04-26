package examen_2023.service;

import examen_2023.model.EstacionMeteorologica;
import examen_2023.model.RegistroDatosDia;

import java.util.*;
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
     * Filtramos las estaciones, nos quedamos con los registros que coincidan con el Id, ordenamos por fecha y
     * pasamos a lista.
     * @param id
     * @return
     */
    public List<RegistroDatosDia> getTempPorEstacion(Long id){
        return estaciones.stream()
               .filter(estacion -> estacion.getId().equals(id))
               .flatMap(estacion -> estacion.getRegistros().stream())
               .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
               .toList();
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
                .sorted(Comparator.comparing(RegistroDatosDia::getTempMedia))
                .filter(registro -> registro.getFecha().getYear() == anio)
                .toList();
    }

    /**
     * Filtramos por comunidad, nos quedamos con los registros de esa comunidad, ordenamos por fecha y lo pasamos
     * a lista.
     * @param comunidad
     * @return los registros pasados a alista.
     */
    public List<RegistroDatosDia> getTempPorComunidad(String comunidad){
        return estaciones.stream()
               .filter(estacion -> estacion.getComunidad().equals(comunidad))
               .flatMap(estacion -> estacion.getRegistros().stream())
               .sorted(Comparator.comparing(RegistroDatosDia::getFecha))
               .toList();
    }

    /**
     * Entramos en los registros de las estaciones, comparamos las temperaturas y nos quedamos con la mayor, en caso
     * de no encontrar ninguna, saltará una excepción.
     * @return la temperatura máxima registrada.
     * @throws NoSuchElementException
     */
    public RegistroDatosDia getTempMaxRegistrada()throws NoSuchElementException {
        return estaciones.stream()
               .flatMap(estacion -> estacion.getRegistros().stream())
               .max(Comparator.comparing(RegistroDatosDia::getTempMax))
               .orElseThrow();
    }

    /**
     * Agrupamos las estaciones meteorológicas por comunidades.
     * @return Un mapa con las estaciones agrupadas.
     */
    public Map<String, List<EstacionMeteorologica>> getEstacionesPorComunidad(){
        return estaciones.stream()
               .collect(Collectors.groupingBy(EstacionMeteorologica::getComunidad));
    }

    /**
     *Entramos en los registros de las estaciones, con anyMatch filtramos y comprobamos si hay algún registro
     * mayor a 30º de temperatura media.
     * @return true si encuentra un registro con la temperatura media mayor a 30º, si no encuentra, devuelve false.
     */
    public boolean isTempMediaAlta(){
        return estaciones.stream()
               .flatMap(estacion -> estacion.getRegistros().stream())
               .anyMatch(registro -> registro.getTempMedia() > 30);
    }
    //devuelve un mapa agrupando por comunidad
    //que contenga la comunidad y la lectura con la temperatura máxima en esa comunidad.

    //public Map<String, Double> getTempMaxPorComunidad(){}
    //.collect(Collectors.toMap(EstacionMeteorologica::getComunidad, estacion -> estacion.getRegistros().stream()
    //                        .mapToDouble(RegistroDatosDia::getTempMax)
    //                        .max()
    //                        .orElseThrow()));

    /**
     * Filtramos las estaciones por comunidades, borramos todas las estaciones que estén dentro de esa comunidad.
     * @param comunidad
     */
    public void borrarEstacionesComunidad(String comunidad){
        estaciones.stream()
                .filter(estacion -> estacion.getComunidad().equals(comunidad))
                .forEach(estacion -> estaciones.remove(estacion));
    }

    /**
     * Llamamos al método getTempPorEstacion, pintamos sus temperaturas pasadas a Farenheit.
     * @param id
     */
    public void pintaEstacionFarenheit(Long id){
        getTempPorEstacion(id)
                .forEach(registro -> {
                    System.out.println("Registro: " + registro.getId());
                    System.out.println("Temperatura máxima: " + (registro.getTempMax() * 9 / 5) + 32);
                    System.out.println("Temperatura mínima: " + (registro.getTempMin() * 9 / 5) + 32);
                    System.out.println("Temperatura media: " + (registro.getTempMedia() * 9 / 5) + 32);
                });
    }

    /**
     * Agrupamos por estación, contamos los registros que tiene cada estación.
     * @return
     */
    public Map<String, Long> getNumRegistros(){
        return estaciones.stream()
               .collect(Collectors.toMap(EstacionMeteorologica::getNombre, estacion -> estacion.getRegistros().stream()
                       .count()));
    }

}
