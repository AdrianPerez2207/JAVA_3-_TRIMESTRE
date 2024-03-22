package practica1.expedienteAlumnos.main;

import practica1.expedienteAlumnos.entidades.*;
import practica1.expedienteAlumnos.servicios.CentroEducativo;

import java.time.LocalDate;

public class test {

    public static void main(String[] args) {
        //Prueba las clases (es laborioso, lo sé) añadiendo unos alumnos, con notas para un par de cursos (1º grado superior
        //daw y 2º grado superior daw). Luego busca el expediente de uno de los alumnos y muéstralo correctamente.

        //Creamos los estudiantes.
        Estudiante e1 = new Estudiante("22436575J", "Adrián", "Pérez Sánchez", LocalDate.of(1996, 7,22)
                , "Calle La Algarroba 27", "Cuevas del Almanzora", "adrianJaroso@gmail.com", "687654321");
        Estudiante e2 = new Estudiante("21435575K", "Antonio", "Pérez Sánchez", LocalDate.of(1998, 3,12)
                , "Calle Albacora 9", "Antas", "antonioJaroso@gmail.com", "612333456");
        Estudiante e3 = new Estudiante("12466575U", "Pedro", "Martínez Fernández", LocalDate.of(1996, 5,27)
                , "Calle La Vieja", "Villaricos", "pedroJaroso@gmail.com", "687111212");
        Estudiante e4 = new Estudiante("55436595L", "Jose Miguel", "Haro Ávila", LocalDate.of(1997, 8,13)
                , "Calle Fenicia 12", "Villaricos", "xemiJaroso@gmail.com", "666094303");
        Estudiante e5 = new Estudiante("34437575M", "Aarón", "Pérez Sánchez", LocalDate.of(1998, 8,29)
                , "Avenida Barcelona 33", "Cuevas del Almanzora", "aaronJaroso@gmail.com", "687000678");
        Estudiante e6 = new Estudiante("12412575N", "José", "Ávila Osorio", LocalDate.of(1997, 1,31)
                , "Calle La Fuente 1", "Las Herrerías", "joseAvilaJaroso@gmail.com", "617999821");
        Estudiante e7 = new Estudiante("22226575V", "Francisco", "Valero Carrillo", LocalDate.of(1991, 9,2)
                , "Calle Las Huertas s/n", "Mojácar", "franciscoJaroso@gmail.com", "622312221");
        Estudiante e8 = new Estudiante("22436222C", "Jerónimo", "Sánchez Sánchez", LocalDate.of(1992, 2,17)
                , "Calle Las Escuelas 2", "Garrucha", "jeroJaroso@gmail.com", "687755433");
        Estudiante e9 = new Estudiante("22434356X", "Juán José", "García Sánchez", LocalDate.of(1994, 6,12)
                , "Calle El Filete 7", "Turre", "juanjoJaroso@gmail.com", "687654543");
        Estudiante e10 = new Estudiante("2958775R", "Raúl", "Navarro Díez", LocalDate.of(1996, 9,15)
                , "Calle La Alpargata 27", "Cuevas del Almanzora", "raulJaroso@gmail.com", "722435678");

        //Creamos los expedientes
        Expediente ex1 = new Expediente(e1, true);
        Expediente ex2 = new Expediente(e2, true);
        Expediente ex3 = new Expediente(e3, true);
        Expediente ex4 = new Expediente(e4, true);
        Expediente ex5 = new Expediente(e5, false);
        Expediente ex6 = new Expediente(e6, true);
        Expediente ex7 = new Expediente(e7, false);
        Expediente ex8 = new Expediente(e8, false);
        Expediente ex9 = new Expediente(e9, true);
        Expediente ex10 = new Expediente(e10, true);

        //Creamos las notas del curso
        NotasCurso n1 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 1, "2023/2024");
        NotasCurso n2 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 1, "2023/2024");
        NotasCurso n3 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 1, "2023/2024");
        NotasCurso n4 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 1, "2023/2024");
        NotasCurso n5 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 1, "2023/2024");
        NotasCurso n6 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 2, "2023/2024");
        NotasCurso n7 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 2, "2023/2024");
        NotasCurso n8 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 2, "2023/2024");
        NotasCurso n9 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 2, "2023/2024");
        NotasCurso n10 = new NotasCurso(EtapaEducativa.FP_SUPERIOR, "DAW", 2, "2023/2024");

        //Añadimos las notas al curso
        n1.addNota("Programación", 7.5);
        n2.addNota("Programación", 7.8);
        n3.addNota("Programación", 6.5);
        n4.addNota("Programación", 4.0);
        n5.addNota("Programación", 10.0);
        n6.addNota("Programación", 9.9);
        n7.addNota("Programación", 3.2);
        n8.addNota("Programación", 1.8);
        n9.addNota("Programación", 4.9);
        n10.addNota("Programación", 6.6);

        n1.addNota("FOL", 6.5);
        n2.addNota("FOL", 1.8);
        n3.addNota("FOL", 9.5);
        n4.addNota("FOL", 2.0);
        n5.addNota("FOL", 0.0);
        n6.addNota("FOL", 6.9);
        n7.addNota("FOL", 1.2);
        n8.addNota("FOL", 8.8);
        n9.addNota("FOL", 6.9);
        n10.addNota("FOL", 6.6);

        n1.addNota("Bases de datos", 2.5);
        n2.addNota("Bases de datos", 4.8);
        n3.addNota("Bases de datos", 6.5);
        n4.addNota("Bases de datos", 8.0);
        n5.addNota("Bases de datos", 6.0);
        n6.addNota("Bases de datos", 9.9);
        n7.addNota("Bases de datos", 10.0);
        n8.addNota("Bases de datos", 8.8);
        n9.addNota("Bases de datos", 3.9);
        n10.addNota("Bases de datos", 7.6);

        //Añadimos las notas al expediente
        ex1.addNotas(n1);
        ex2.addNotas(n2);
        ex3.addNotas(n3);
        ex4.addNotas(n4);
        ex5.addNotas(n5);
        ex6.addNotas(n6);
        ex7.addNotas(n7);
        ex8.addNotas(n8);
        ex9.addNotas(n9);
        ex10.addNotas(n10);

        //Creamos el centro educativo
        CentroEducativo centroEducativo = new CentroEducativo("IES JAroso", "C/ La estación",
                "Cuevas del Almanzora", "950122323", "jarosoCentro@gmail.com");

        //Añadimos los expedientes al centro educativo
        centroEducativo.addExpediente(ex1);
        centroEducativo.addExpediente(ex2);
        centroEducativo.addExpediente(ex3);
        centroEducativo.addExpediente(ex4);
        centroEducativo.addExpediente(ex5);
        centroEducativo.addExpediente(ex6);
        centroEducativo.addExpediente(ex7);
        centroEducativo.addExpediente(ex8);
        centroEducativo.addExpediente(ex9);
        centroEducativo.addExpediente(ex10);

        //Mostramos el expediente
        System.out.println(centroEducativo.buscarExpedientes("22436575J"));
        System.out.println("--------Stream-----------");
        centroEducativo.mostrarExpedientesStrem("22436575J");

        System.out.println("--------Pintar notas----------");
        centroEducativo.buscarExpedientes("22436575J").mostrarNotas(1, EtapaEducativa.FP_SUPERIOR);
        System.out.println("--------Stream-----------");
        centroEducativo.buscarExpedientes("22436575J").mostrarNotasStreams(1, EtapaEducativa.FP_SUPERIOR);

        System.out.println("Pintamos las notas");
        n3.pintar();
    }
}
