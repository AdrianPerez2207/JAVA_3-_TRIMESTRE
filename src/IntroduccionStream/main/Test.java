package IntroduccionStream.main;

import IntroduccionStream.entidades.Registro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Test {
    public static Double numerosAleatorios(Double minimo, Double maximo){
        return Math.random() * (maximo - minimo) + minimo;
    }

    /**
     * creamos 100 resgistros
     * @param numRegistros
     * @param fechaInicial
     */
    public static List<Registro> crearRegistros(Integer numRegistros, LocalDateTime fechaInicial){
        List<Registro> registros = new ArrayList<>();
        for (int i = 0; i < numRegistros; i++) {
            Registro registro = new Registro(fechaInicial.plusMinutes(i), numerosAleatorios(-20.0, 45.0),
                    numerosAleatorios(0.0, 100.0));
            registros.add(registro);
        }
        return registros;
    }
    private static void EjercicioJ(List<Registro> registros) {
        Double temperaturaPromedio = registros.stream()
                .mapToDouble(registro -> registro.getTemperatura())
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(temperaturaPromedio);
        System.out.println();
    }

    private static void ejercicioI(List<Registro> registros) {
        Long cuentaTemperatura= registros.stream()
                .filter(registro -> registro.getTemperatura() > 35)
                .count();
        System.out.println(cuentaTemperatura);
        System.out.println();
    }

    private static void ejercicioH(List<Registro> registros) {
        registros.stream()
                .sorted((r1,r2) -> r1.getFechaHora().compareTo(r2.getFechaHora()))
                .forEach(System.out::println);
        System.out.println();
    }

    private static void ejercicioG(List<Registro> registros) {
        registros.stream()
                .skip(5)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void ejercicioF(List<Registro> registros) {

        System.out.println(registros.stream()
                .anyMatch(registro -> registro.getTemperatura() > 30 && registro.getHumedad() > 90
                        && registro.getFechaHora().toLocalDate().equals(LocalDate.now())));
    }

    private static void ejercicioE(List<Registro> registros) {
        Registro registro3 = registros.stream()
                .filter(registro -> registro.getHumedad() > 80)
                .min(Comparator.comparing(Registro::getTemperatura))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(registro3);
        System.out.println();
    }

    private static void ejercicioD(List<Registro> registros) {
        registros.stream()
                .peek(registro -> registro.setHumedad(registro.getHumedad() + 5.0))
                .forEach(System.out::println);
        System.out.println();
    }

    private static void ejercicioC(List<Registro> registros) {
        registros.stream()
                .map(registro -> registro.getFechaHora())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void ejercicioB(List<Registro> registros) {
        Registro maximaTemperatura = registros.stream()
                .max(Comparator.comparing(Registro::getTemperatura))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maximaTemperatura);
        System.out.println();
        //Nos quedamos solo con la temperatura y pintamos la maxima (sólo pinta el número de la temperatura)
        //registros.stream()
        //       .map(registro -> registro.getTemperatura())
        //       .max()
        //       .ifPresent(System.out::println);

        //Comparamos las temperaturas y pintamos el registro completo.
        //registros.stream()
        //       .max(Comparator.compating(Registro::getTemperatura))
        //       .ifPresent(System.out::println);
    }

    private static void ejercicioA(List<Registro> registros) {
        registros.stream()
                .filter(registro -> registro.getTemperatura() > 25)
                .filter(registro -> registro.getHumedad() < 70)
                .filter(registro -> registro.getFechaHora().isBefore(LocalDateTime.now()))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Registro> registros = crearRegistros(100, LocalDateTime.of(2024, 3,21,
                22, 14, 00 ));
        //a. Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70
        // y la fecha sea anterior a la fecha actual, y mostrarlos.
        System.out.println("----------Filtrado temperatura, humedad y fecha---------");
        ejercicioA(registros);


        //b. Encontrar el registro con la temperatura más alta y mostrar el registro completo.
        System.out.println("----------Temperatura máxima---------");
        ejercicioB(registros);


        //c. Obtener una lista con las fechas/horas de todas las tomas de datos.
        System.out.println("----------Fecha/Hora---------");
        ejercicioC(registros);


        //d. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
        //humedades y fechas/horas actualizadas.
        System.out.println("----------Humedad añadida---------");
        ejercicioD(registros);


        //e. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y
        //mostrar la temperatura, humedad y fecha.
        System.out.println("----------Temperatura más baja con humedad > 80---------");
        ejercicioE(registros);


        //f. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y
        //la fecha es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta
        //condición o no.
        System.out.println("----------Temperatura mayor a 30 grados y humedad > 90---------");
        ejercicioF(registros);


        //g. Muestra 10 registros saltándote los 5 primeros.
        System.out.println("----------10 registros saltándote los 5 primeros---------");
        ejercicioG(registros);


        //h. Muestra los registros ordenados por fecha (sorted(Comparator))
        // Como expresión lambda: (r1,r2) -> r1.getFechaHora().compareTo(r2.getFechaHora())
        System.out.println("----------Registros ordenador por fecha---------");
        ejercicioH(registros);


        //i. Cuenta los registros que tengan temperatura mayor a 35 grados (count()).
        System.out.println("----------Temperatura mayor a 35º---------");
        ejercicioI(registros);


        //j. Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double>
        //y llamar a average())
        System.out.println("----------Temperatura promedio---------");
        EjercicioJ(registros);


    }
}
