package practica2_streams.ejercicio1.main;

import practica2_streams.ejercicio1.entidades.Juego;
import practica2_streams.ejercicio1.entidades.Puntuacion;
import practica2_streams.ejercicio1.entidades.Usuario;
import practica2_streams.ejercicio1.servicios.Steam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestPuntuaciones {
    //Método que reciba como parámetro un Usuario y muestre todas sus puntuaciones (puntos,
    //partidas jugadas, …) ordenadas por puntos.
    public static void puntuacionesJugador(Usuario usuario1, Steam steam){
        steam.getJugadores().stream()
                .filter(usuario -> usuario.equals(usuario1))
                .peek(usuario -> System.out.println("Nombre: " + usuario.getNick()))
                .flatMap(usuario -> usuario.getPuntuaciones().values().stream())
                .sorted(Comparator.comparing(usuario -> usuario.getPuntos()))
                .forEach(System.out::println);
    }
    //Método que muestre cada usuario (Nick) y para cada uno la puntuación de los juegos a los
    //que juega.
    private static void usuariosYPuntuaciones(Steam steam) {
        steam.getJugadores().stream()
                .sorted(Comparator.comparing(Usuario::getNick))
                .peek(usuario -> System.out.println("Usuario: " + usuario.getNick()))
                .flatMap(usuario -> usuario.getPuntuaciones().values().stream())
                .forEach(System.out::println);
    }
    //Muestra por pantalla todos los usuarios ordenados por Nick, muestra email y Nick
    private static void usuariosOrdenadosNick(Steam steam) {
        System.out.println("Usuarios ordenados por nick: ");
        steam.getJugadores().stream()
                .sorted(Comparator.comparing(Usuario::getNick))
                .forEach(usuario -> System.out.printf("Nick: %s - Email: %s", usuario.getNick(), usuario.getEmail() + "\n"));
    }



    public static void main(String[] args) {
        Juego j1 = new Juego("Hunt Showdown", "Steam");
        Juego j2 = new Juego("Counter Strike", "Steam");
        Juego j3 = new Juego("League of Legends", "Riot Games");
        Juego j4 = new Juego("GTA V", "Epic Games");
        Juego j5 = new Juego("Day Z", "Steam");
        Juego j6 = new Juego("Valorant", "Riot Games");
        Juego j7 = new Juego("Fornite", "Epic Games");
        Juego j8 = new Juego("Word of Tanks", "Steam");
        Juego j9 = new Juego("WOW", "Blizards");
        Juego j10 = new Juego("Call of Dutty", "Blizards");

        Steam steam = new Steam();
        steam.addJuego(j1);
        steam.addJuego(j2);
        steam.addJuego(j3);
        steam.addJuego(j4);
        steam.addJuego(j5);
        steam.addJuego(j6);
        steam.addJuego(j7);
        steam.addJuego(j8);
        steam.addJuego(j9);
        steam.addJuego(j10);

        Usuario u1 = new Usuario("Adrián", "email1@gmail.com", "Norteño");
        Usuario u2 = new Usuario("Gabriel", "email2@gmail.com", "Comparitiko");
        Usuario u3 = new Usuario("Robert", "email3@gmail.com", "Topeta14");
        Usuario u4 = new Usuario("Alejandro", "email4@gmail.com", "AlexRed");
        Usuario u5 = new Usuario("Martín", "email5@gmail.com", "Apoyardao22");
        Usuario u6 = new Usuario("Juan Antonio", "email6@gmail.com", "SobrinoElLoliki");
        Usuario u7 = new Usuario("Deivyd", "email7@gmail.com", "DarkysitoElUnico");
        Usuario u8 = new Usuario("Francisco", "email8@gmail.com", "Naskael");
        Usuario u9 = new Usuario("Diego", "email9@gmail.com", "Mojon");
        Usuario u10 = new Usuario("Diego2", "email10@gmail.com", "Setupy");

        steam.addUsuario(u1);
        steam.addUsuario(u2);
        steam.addUsuario(u3);
        steam.addUsuario(u4);
        steam.addUsuario(u5);
        steam.addUsuario(u6);
        steam.addUsuario(u7);
        steam.addUsuario(u8);
        steam.addUsuario(u9);
        steam.addUsuario(u10);

        //Usuario 1
        u1.addPuntuacion(j1.getId(), true, 200);
        u1.addPuntuacion(j2.getId(), true, 100);
        u1.addPuntuacion(j3.getId(), false, 20);
        u1.addPuntuacion(j6.getId(), false, 30);
        u1.addPuntuacion(j5.getId(), true, 150);
        //Usuario 2
        u2.addPuntuacion(j7.getId(), true, 200);
        u2.addPuntuacion(j2.getId(), true, 100);
        u2.addPuntuacion(j10.getId(), false, 20);
        u2.addPuntuacion(j6.getId(), false, 30);
        u2.addPuntuacion(j9.getId(), true, 300);
        //Usuario 3
        u3.addPuntuacion(j4.getId(), true, 200);
        u3.addPuntuacion(j2.getId(), true, 100);
        u3.addPuntuacion(j8.getId(), false, 40);
        u3.addPuntuacion(j7.getId(), true, 200);
        u3.addPuntuacion(j9.getId(), false, 10);
        //Usuario 4
        u4.addPuntuacion(j1.getId(), true, 120);
        u4.addPuntuacion(j2.getId(), false, 80);
        u4.addPuntuacion(j5.getId(), false, 40);
        u4.addPuntuacion(j7.getId(), true, 200);
        u4.addPuntuacion(j10.getId(), false, 10);
        //Usuario 5
        u5.addPuntuacion(j3.getId(), true, 200);
        u5.addPuntuacion(j6.getId(), true, 100);
        u5.addPuntuacion(j4.getId(), false, 40);
        u5.addPuntuacion(j7.getId(), true, 200);
        u5.addPuntuacion(j9.getId(), false, 10);
        //Usuario 6
        u6.addPuntuacion(j1.getId(), true, 200);
        u6.addPuntuacion(j2.getId(), true, 100);
        u6.addPuntuacion(j6.getId(), false, 40);
        u6.addPuntuacion(j9.getId(), true, 200);
        u6.addPuntuacion(j10.getId(), false, 10);
        //Usuario 7
        u7.addPuntuacion(j1.getId(), true, 200);
        u7.addPuntuacion(j2.getId(), true, 100);
        u7.addPuntuacion(j3.getId(), false, 40);
        u7.addPuntuacion(j6.getId(), true, 200);
        u7.addPuntuacion(j5.getId(), false, 10);
        //Usuario 8
        u8.addPuntuacion(j4.getId(), true, 200);
        u8.addPuntuacion(j6.getId(), true, 100);
        u8.addPuntuacion(j8.getId(), false, 40);
        u8.addPuntuacion(j9.getId(), true, 200);
        u8.addPuntuacion(j10.getId(), false, 10);
        //Usuario 9
        u9.addPuntuacion(j4.getId(), true, 200);
        u9.addPuntuacion(j2.getId(), true, 100);
        u9.addPuntuacion(j8.getId(), false, 40);
        u9.addPuntuacion(j7.getId(), true, 200);
        u9.addPuntuacion(j9.getId(), false, 10);
        //Usuario 10
        u10.addPuntuacion(j1.getId(), true, 200);
        u10.addPuntuacion(j2.getId(), true, 100);
        u10.addPuntuacion(j5.getId(), false, 40);
        u10.addPuntuacion(j7.getId(), true, 200);
        u10.addPuntuacion(j10.getId(), false, 10);



        usuariosOrdenadosNick(steam);
        System.out.println("-----------------------------------");
        usuariosYPuntuaciones(steam);
        System.out.println("-----------------------------------");
        puntuacionesJugador(u4, steam);



    }
}
