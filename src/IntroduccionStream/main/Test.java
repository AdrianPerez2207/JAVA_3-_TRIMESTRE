package IntroduccionStream.main;

import IntroduccionStream.entidades.Registro;

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

    public static void main(String[] args) {
        List<Registro> registros = crearRegistros(100, LocalDateTime.of(2024, 3,21,
                22, 14, 00 ));
        //a. Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70
        // y la fecha sea anterior a la fecha actual, y mostrarlos.
        System.out.println("----------Filtrado temperatura, humedad y fecha---------");
        registros.stream()
                .filter(registro -> registro.getTemperatura() > 25)
                .filter(registro -> registro.getHumedad() < 70)
                .filter(registro -> registro.getFechaHora().isBefore(LocalDateTime.now()))
                .forEach(System.out::println);
        System.out.println();


        //b. Encontrar el registro con la temperatura más alta y mostrar el registro completo.
        System.out.println("----------Temperatura máxima---------");
        Registro maximaTemperatura = registros.stream()
                .max(Comparator.comparing(Registro::getTemperatura))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maximaTemperatura);
        System.out.println();


        //c. Obtener una lista con las fechas/horas de todas las tomas de datos.
        System.out.println("----------Fecha/Hora---------");
        registros.stream()
                .map(registro -> registro.getFechaHora())
                .forEach(System.out::println);
        System.out.println();




        //d. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
        //humedades y fechas/horas actualizadas.
        System.out.println("----------Humedad añadida---------");
        registros.stream()
                .peek(registro -> registro.setHumedad(registro.getHumedad() + 5.0))
                .forEach(System.out::println);
        System.out.println();


        //e. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y
        //mostrar la temperatura, humedad y fecha.
        System.out.println("----------Temperatura más baja con humedad > 80---------");
        Registro registro3 = registros.stream()
                .filter(registro -> registro.getHumedad() > 80)
                .min(Comparator.comparing(Registro::getTemperatura))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(registro3);
        System.out.println();



        //f. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y
        //la fecha es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta
        //condición o no.
        System.out.println("----------Temperatura mayor a 30 grados y humedad > 90---------");
        registros.stream()
                .filter(registro -> registro.getTemperatura() > 30)
                .filter(registro -> registro.getHumedad() > 90)
                .filter(registro -> registro.getFechaHora().equals(LocalDateTime.now()));
        System.out.println();


        //g. Muestra 10 registros saltándote los 5 primeros.
        System.out.println("----------10 registros saltándote los 5 primeros---------");
        registros.stream()
                .skip(5)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();


        //h. Muestra los registros ordenados por fecha (sorted(Comparator))
        // Como expresión lambda: (r1,r2) -> r1.getFechaHora().compareTo(r2.getFechaHora())
        System.out.println("----------Registros ordenador por fecha---------");
        registros.stream()
                .sorted((r1,r2) -> r1.getFechaHora().compareTo(r2.getFechaHora()))
                .forEach(System.out::println);
        System.out.println();



        //i. Cuenta los registros que tengan temperatura mayor a 35 grados (count()).
        System.out.println("----------Temperatura mayor a 35º---------");
        Long cuentaTemperatura= registros.stream()
                .filter(registro -> registro.getTemperatura() > 35)
                .count();
        System.out.println(cuentaTemperatura);
        System.out.println();



        //j. Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double>
        //y llamar a average())
        System.out.println("----------Temperatura promedio---------");
        Double temperaturaPromedio = registros.stream()
                .mapToDouble(registro -> registro.getTemperatura())
                .average()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(temperaturaPromedio);
        System.out.println();



    }
}
