package practica1.expedienteAlumnos.entidades;

import java.util.HashSet;
import java.util.Objects;

public class Expediente {
    private Estudiante estudiante;
    private HashSet<NotasCurso> notas;
    private boolean activo;

    public Expediente(Estudiante estudiante, boolean activo) {
        this.estudiante = estudiante;
        this.activo = activo;
        this.notas = new HashSet<>();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public HashSet<NotasCurso> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expediente{");
        sb.append("estudiante=").append(estudiante);
        sb.append(", notas=").append(notas);
        sb.append(", activo=").append(activo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expediente that = (Expediente) o;
        return Objects.equals(estudiante, that.estudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudiante);
    }

    //mostrarNotas(int curso, String etapa) que mostrará todas las notas de este estudiante
    // para una etapa y un curso concreto.

    //Métodos----
    public void addNotas(NotasCurso nc) {
        this.notas.add(nc);
    }

    /**
     * Buscamos en las notas el curso y la etapa que coincida con las pasadas por parámetro.
     * Si lo enuentra lo imprime por pantalla.
     * @param curso
     * @param etapa
     */
    public void mostrarNotas(Integer curso, String etapa){
        for (NotasCurso nc : this.notas) {
            if (nc.getCurso().equals(curso) && nc.getEtapaEducativa().equals(etapa)) {
                System.out.println(nc);
            }
        }
    }

    /**
     * Aquí hago el mismo método pero con streams para practicar.
     * Le paso 2 filtros. Si coinciden con la nota y la etapa pasadas por parámetro, los imprime.
     * @param curso
     * @param etapa
     */
    public void mostrarNotasStreams(Integer curso, String etapa){
        notas.stream()
                .filter(notasCurso -> notasCurso.getCurso().equals(curso))
                .filter(notasCurso -> notasCurso.getEtapaEducativa().equals(etapa))
                .forEach(System.out::println);
    }
}
