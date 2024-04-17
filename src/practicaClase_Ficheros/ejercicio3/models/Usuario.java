package practicaClase_Ficheros.ejercicio3.models;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private  String nombre;
    private String apellidos;
    private String genero;
    private String dni;
    private LocalDate fechaNacimiento;
    private String login;
    private String password;

    public Usuario(String nombre, String apellidos, String genero, String dni, LocalDate fechaNacimiento, String login,
                   String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.login = login;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
