package practica3_ficheros.main;

import practica3_ficheros.entidades.Finca;
import practica3_ficheros.entidades.Lectura;
import practica3_ficheros.io.DAOFinca;
import practica3_ficheros.io.DAOLectura;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws IOException {
        new DAOFinca();

        DAOFinca.addFinca(new Finca(11L, "Cupillas", 21.45, 55.64, 124.67,
                "Cuevas", "Almeria"));
        DAOFinca.getFincas().forEach(System.out::println);

        new DAOLectura();
        System.out.println("---------- Parte fincas ---------");
        System.out.println("Fincas por superficie ");
        DAOFinca.getFincasPorSuperficie().forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Fincas más grandes");
        DAOFinca.getMasGrandes().forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Fincas por ciudad");
        DAOFinca.getFincasPorCiudad().forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        System.out.println("-------------------------");
        System.out.println("Fincas entre 50 y 150 m");
        DAOFinca.getFincasMedio().forEach(System.out::println);
        System.out.println("---------- Parte lecturas ----------");
        System.out.println("Lecturas por fincas");
        DAOLectura.getLecturasPorFinca().forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        System.out.println("-------------------------");
        System.out.println("Temperatura máxima de una finca");
        System.out.println(DAOLectura.getTempMaximaFinca(4L));
        System.out.println("-------------------------");
        System.out.println("Temperatura mínima de una finca");
        System.out.println(DAOLectura.getTempMinimaFinca(4L));
        System.out.println("-------------------------");
        System.out.println("Humedades finca");
        DAOLectura.getHumedadPorFinca(8L).forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Temperatura por finca");
        DAOLectura.getTemperaturaPorFinca(10L).forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Temperatura por día");
        DAOLectura.getTempDiaPorFinca(4L, LocalDate.of(2024, 4, 6))
                .forEach(System.out::println);

        //Eliminamos las lecturas.
        DAOLectura.removeLectura(DAOLectura.findById(998L));
        DAOLectura.removeLectura(DAOLectura.findById(990L));
        DAOLectura.removeLectura(DAOLectura.findById(996L));
        DAOLectura.removeLectura(DAOLectura.findById(8L));
        DAOLectura.removeLectura(DAOLectura.findById(6L));

        DAOLectura.guardarDatos();
    }
}
