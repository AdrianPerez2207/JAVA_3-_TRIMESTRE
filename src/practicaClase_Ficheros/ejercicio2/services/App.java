package practicaClase_Ficheros.ejercicio2.services;

import practicaClase_Ficheros.ejercicio2.io.DAOGamer;
import practicaClase_Ficheros.ejercicio2.models.Gamer;
import practicaClase_Ficheros.ejercicio2.models.Levels;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        List<Gamer> gamers = DAOGamer.loadGamers();

        Discord discord = new Discord(gamers);

        //Menú
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5){
            System.out.println("1. Listar Jugadores.");
            System.out.println("2. Añadir Jugador.");
            System.out.println("3. Eliminar Jugador.");
            System.out.println("4. Buscar Jugador por Nick.");
            System.out.println("5. Guardar y Salir.");

            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    discord.listGamers();
                    break;
                case 2:
                    System.out.println("Escribe el Nick del Jugador.");
                    String nick = sc.nextLine();
                    System.out.println("Escribe el Email del Jugador.");
                    String email = sc.nextLine();
                    System.out.println("Escribe el Juego.");
                    String juego = sc.nextLine();
                    System.out.println("Escribe el Nivel:(DIOS, MÁQUINA, BUENO, NORMAL, REGULAR, MALILLO, PAQUETE)");
                    Levels nivel = Levels.valueOf(sc.nextLine());

                    Gamer gamer = new Gamer(discord.getMaxId() + 1, nick, email, juego, nivel);
                    discord.addGamer(gamer);
                    break;
                case 3:
                    System.out.println("Escribe un email: ");
                    String emailABorrar = sc.nextLine();
                    Gamer gamerRemove = new Gamer(1L, " ",emailABorrar, " ", null);
                    discord.removeGamer(gamerRemove);
                    break;
                case 4:
                    System.out.println("Escribe el Nick del Jugador: ");
                    String buscarNick = sc.nextLine();
                    try {
                        System.out.println(discord.findGamer(buscarNick));
                    } catch (NoSuchElementException ex){
                        System.out.println("No se encontró el jugador");
                    }
                    break;
                case 5:
                    //Al salir tenemos que guardar el fichero. Espera una lista, por eso pasamos el getGamers() a lista.
                    DAOGamer.saveGamers(discord.getGamers().stream().toList());
                    System.out.println("¡Adiós!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }

    }
}
