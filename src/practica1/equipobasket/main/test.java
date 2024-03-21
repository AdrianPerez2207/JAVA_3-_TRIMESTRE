package practica1.equipobasket.main;

import practica1.equipobasket.entidades.*;

public class test {

    public static Double numerosAleatorios(Double minimo, Double maximo){
        return Math.random() * (maximo - minimo) + minimo;
    }

    /**
     * Recorremos los equipos de la liga, dentro de cada equipo creamos y añadimos a 5 jugadores.
     * @param league
     */
    private static void crearJugadores(NBALeague league) {
        for (String equipo : league.getEquipos().keySet()){
            for (int i = 0; i < 5; i++) {
                league.getEquipos().get(equipo).addJugador(new JugadorBasket("jugador" + i, numerosAleatorios(150.0, 210.2), "PIVOT", i,
                        numerosAleatorios(0.0, 40.0), numerosAleatorios(0.0, 10.6), numerosAleatorios(0.0, 35.6), numerosAleatorios(0.0, 32.6),
                        numerosAleatorios(0.0, 10.6)));
            }
        }
    }

    public static void main(String[] args) {
        NBALeague league = new NBALeague();

        league.addEquipos("Chicago Bulls", new EquipoBasket("Chicago Bulls", 34.0, 35.0));
        league.addEquipos("Boston Celtics", new EquipoBasket("Boston Celtics", 55.0, 14.0));
        league.addEquipos("Los Angeles Lakers", new EquipoBasket("Los Angeles Lakers", 37.0, 32.0));
        league.addEquipos("Dallas Mavericks", new EquipoBasket("Dallas Mavericks", 40.0, 29.0));
        league.addEquipos("Memphis Grizzlies", new EquipoBasket("Memphis Grizzlies", 23.0, 47.0));
        league.addEquipos("Miami Heat", new EquipoBasket("Miami Heat", 38.0, 31.0));
        league.addEquipos("Toronto Raptors", new EquipoBasket("Toronto Raptors", 23.0, 46.0));

        crearJugadores(league);
        league.mostrarEquipos();

        System.out.println("-----------------------------");
        league.mostrarEquiposOrdenados();
        System.out.println("-----------------------------");
        System.out.println("Jugador más alto: " + league.buscarJugadorAlto());
        System.out.println("-----------------------------");
        System.out.println("Equipo con más victorias: " + league.buscarPartidosGanados());
        System.out.println("-----------------------------");
        System.out.println("Jugador de Chicago Bulls por dorsal: " + league.getEquipos().get("Chicago Bulls").buscarJugadores(4));
        System.out.println("-----------------------------");
        System.out.println("Jugador de Chicago Bulls por nombre: " + league.getEquipos().get("Boston Celtics").buscarJugador("jugador1"));
    }

}
