package practica2_streams.ejercicio1.main;

import practica2_streams.ejercicio1.entidades.Juego;
import practica2_streams.ejercicio1.entidades.Usuario;

public class Main {

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



    }
}
