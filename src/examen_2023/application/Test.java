package examen_2023.application;

import examen_2023.model.EstacionMeteorologica;
import examen_2023.model.RegistroDatosDia;
import examen_2023.service.ServicioGeneralMeteorologico;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        RegistroDatosDia r1 = new RegistroDatosDia(1L, LocalDate.now(), 34.8, -10.5, 18.56);
        RegistroDatosDia r2 = new RegistroDatosDia(2L, LocalDate.of(2024, 4, 23), 28.50, -10.5, 18.56);
        RegistroDatosDia r3 = new RegistroDatosDia(3L, LocalDate.now(), 40.50, -10.5, 38.56);

        EstacionMeteorologica e1 = new EstacionMeteorologica(4L, "La serena", "Andalucia", 45.56, 23.76);
        EstacionMeteorologica e2 = new EstacionMeteorologica(6L, "Tetica", "Andalucía", 50.56, 13.76);

        e1.nuevoRegistro(r1);
        e1.nuevoRegistro(r2);
        e2.nuevoRegistro(r3);

        ServicioGeneralMeteorologico s1 = new ServicioGeneralMeteorologico();
        s1.nuevaEstacion(e1);
        s1.nuevaEstacion(e2);

        System.out.println("---------");
        System.out.println(s1.getTempPorEstacion(4L));
        System.out.println("---------");
        System.out.println(s1.getTempPorAnioEstacion(4L, 2024));
        System.out.println(s1.getTempMaxRegistrada());

        System.out.println("---------");
        s1.getEstacionesPorComunidad().forEach((k,v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        System.out.println("---------");
        System.out.println(s1.isTempMediaAlta());
        System.out.println("---------");
        s1.pintaEstacionFarenheit(4L);
        System.out.println("---------");
        s1.getNumRegistros().forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
