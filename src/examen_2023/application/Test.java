package examen_2023.application;

import examen_2023.model.EstacionMeteorologica;
import examen_2023.model.RegistroDatosDia;
import examen_2023.service.ServicioGeneralMeteorologico;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        RegistroDatosDia r1 = new RegistroDatosDia(1L, LocalDate.now(), 34.50, -10.5, 18.56);
        RegistroDatosDia r2 = new RegistroDatosDia(2L, LocalDate.of(2024, 4, 23), 34.50, -10.5, 18.56);
        RegistroDatosDia r3 = new RegistroDatosDia(3L, LocalDate.now(), 34.50, -10.5, 18.56);

        EstacionMeteorologica e1 = new EstacionMeteorologica(4L, "La serena", "Andalucia", 45.56, 23.76);
        EstacionMeteorologica e2 = new EstacionMeteorologica(6L, "Tetica", "Andalucia", 50.56, 13.76);

        e1.nuevoRegistro(r1);
        e1.nuevoRegistro(r2);
        e2.nuevoRegistro(r3);

        ServicioGeneralMeteorologico s1 = new ServicioGeneralMeteorologico();
        s1.nuevaEstacion(e1);
        s1.nuevaEstacion(e2);


        System.out.println(s1.getTempPorAnioEstacion(4L, 2024));
    }
}
