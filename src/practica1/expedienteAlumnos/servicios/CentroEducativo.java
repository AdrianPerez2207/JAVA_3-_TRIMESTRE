package practica1.expedienteAlumnos.servicios;

import practica1.expedienteAlumnos.entidades.Expediente;

import java.util.Objects;
import java.util.TreeSet;

public class CentroEducativo {
    private TreeSet<Expediente> expedientes;
    private String nombreCentro;
    private String direccion;
    private String localidad;
    private String telefono;
    private String email;

    public CentroEducativo(String nombreCentro, String direccion, String localidad, String telefono, String email) {
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.email = email;
        this.expedientes = new TreeSet<>();
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public TreeSet<Expediente> getExpedientes() {
        return expedientes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CentroEducativo{");
        sb.append("expedientes=").append(expedientes);
        sb.append(", nombreCentro='").append(nombreCentro).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", localidad='").append(localidad).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroEducativo that = (CentroEducativo) o;
        return Objects.equals(nombreCentro, that.nombreCentro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCentro);
    }
    //Métodos---
    public void addExpediente(Expediente expediente) {
        this.expedientes.add(expediente);
    }

    /**
     * Buscamos en los expedientes el que coincida con el dni.
     * @param dni
     * @return el expediente.
     */
    public Expediente buscarExpedientes(String dni){
        for (Expediente ex : expedientes){
            if (ex.getEstudiante().getDni().equals(dni)){
                return ex;
            }
        }
        return null;
    }

    /**
     * Dado un expediente, buscamos que los dni de los estudiantes coincidan con el pasado por parámetro.
     * @param dni
     */
    public void mostrarExpedientesStrem(String dni){
        expedientes.stream()
                .filter(expediente -> expediente.getEstudiante().getDni().equals(dni))
                .forEach(System.out::println);
    }
}
