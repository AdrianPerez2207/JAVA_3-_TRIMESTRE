package practica1.equipobasket.entidades;

import java.util.Objects;

public class JugadorBasket implements Comparable<JugadorBasket>{
    private String nombre;
    private Double altura;
    private String posicion;
    private Integer dorsal;
    private Double puntosPorPartido;
    private Double rebotesPorPartido;
    private Double taponesPorPartido;
    private Double asistenciasPorPartido;
    private Double robosPorPartido;

    public JugadorBasket(String nombre, Double altura, String posicion, Integer dorsal, Double puntosPorPartido,
                         Double rebotesPorPartido, Double taponesPorPartido, Double asistenciasPorPartido,
                         Double robosPorPartido) {
        this.nombre = nombre;
        this.altura = altura;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.puntosPorPartido = puntosPorPartido;
        this.rebotesPorPartido = rebotesPorPartido;
        this.taponesPorPartido = taponesPorPartido;
        this.asistenciasPorPartido = asistenciasPorPartido;
        this.robosPorPartido = robosPorPartido;
    }

    public JugadorBasket(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(Double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    public Double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(Double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    public Double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(Double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    public Double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(Double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    public Double getRobosPorPartido() {
        return robosPorPartido;
    }

    public void setRobosPorPartido(Double robosPorPartido) {
        this.robosPorPartido = robosPorPartido;
    }

    @Override
    public String toString() {
        return "JugadorBasket{" +
                "nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                ", puntosPorPartido=" + puntosPorPartido +
                ", rebotesPorPartido=" + rebotesPorPartido +
                ", taponesPorPartido=" + taponesPorPartido +
                ", asistenciasPorPartido=" + asistenciasPorPartido +
                ", robosPorPartido=" + robosPorPartido +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorBasket that = (JugadorBasket) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Interfaz comparable.
     * @param o the object to be compared.
     * @return 0 si el nombre coincide, 1 si es mayor, y -1 si es menor.
     */

    @Override
    public int compareTo(JugadorBasket o) {
        return this.nombre.compareTo(o.getNombre());
    }
}
