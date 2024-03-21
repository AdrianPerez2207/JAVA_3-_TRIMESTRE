package practica1.expedienteAlumnos.entidades;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public class NotasCurso {
    private EtapaEducativa etapaEducativa;
    private String nombreCiclo;
    private Integer curso;
    private HashMap<String, Double> notas;
    private String anio;


    public NotasCurso(EtapaEducativa etapaEducativa, String nombreCiclo, Integer curso, String anio) {
        this.etapaEducativa = etapaEducativa;
        this.nombreCiclo = nombreCiclo;
        this.curso = curso;
        this.anio = anio;
        this.notas = new HashMap<>();
    }

    public EtapaEducativa getEtapaEducativa() {
        return etapaEducativa;
    }

    public void setEtapaEducativa(EtapaEducativa etapaEducativa) {
        this.etapaEducativa = etapaEducativa;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    public HashMap<String, Double> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NotasCurso{");
        sb.append("etapaEducativa=").append(etapaEducativa);
        sb.append(", nombreCiclo='").append(nombreCiclo).append('\'');
        sb.append(", curso=").append(curso);
        sb.append(", notas=").append(notas);
        sb.append(", anio='").append(anio).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotasCurso that = (NotasCurso) o;
        return etapaEducativa == that.etapaEducativa && Objects.equals(nombreCiclo, that.nombreCiclo) && Objects.equals(curso, that.curso) && Objects.equals(anio, that.anio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etapaEducativa, nombreCiclo, curso, anio);
    }

    //Métodos--------
    public void addNota(String asignatura, Double nota) {
        this.notas.put(asignatura, nota);
    }
    public void deleteNota(String asignatura) {
        this.notas.remove(asignatura);
    }
    public Double buscarNota(String asignatura) {
        return this.notas.get(asignatura);
    }

    /**
     * Pasamos todas las notas y asignaturas a un TreeMap, por defecto ya lo ordena por la clave.
     * Pintamos directamente en el método.
     */
    public void pintar() {
        System.out.println(new TreeMap<String, Double>(notas));
    }
}
