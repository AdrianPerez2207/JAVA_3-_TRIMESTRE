package practicaClase_Ficheros.ejercicio2.services;

import practicaClase_Ficheros.ejercicio2.io.DAOGamer;
import practicaClase_Ficheros.ejercicio2.models.Gamer;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        List<Gamer> gamers = DAOGamer.loadGamers();

        Discord discord = new Discord(gamers);

        //Menú
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5){
            System.out.println("1. Listar.");
            System.out.println("2. Añadir.");
            System.out.println("3. Buscar por Nick.");
            System.out.println("4. Eliminar.");
            System.out.println("5. Salir.");

            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    discord.listGamers();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
