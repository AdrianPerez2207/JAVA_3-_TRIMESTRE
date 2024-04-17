package practicaClase_Ficheros.ejercicio2.services;

import practicaClase_Ficheros.ejercicio2.models.Gamer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Discord {
    private HashSet<Gamer> gamers;

    public Discord() {
        this.gamers = new HashSet<>();
    }
    public Discord(List<Gamer> gamers){
        this.gamers = new HashSet<>(gamers);
    }

    public HashSet<Gamer> getGamers() {
        return gamers;
    }
    public void addGamer(Gamer gamer) {
        this.gamers.add(gamer);
    }
    public void removeGamer(Gamer gamer) {
        this.gamers.remove(gamer);
    }

    public void setGamers(HashSet<Gamer> gamers) {
        this.gamers = gamers;
    }

    public Gamer findGamer(String nick)throws NoSuchElementException {
        return gamers.stream()
                .filter(gamer -> gamer.getNick().equals(nick))
                .findFirst()
                .orElseThrow();
    }
    public void listGamers(){
        //gamers.forEach(System.out::println);
        gamers.stream()
                .sorted(Comparator.comparing(Gamer::getId))
                .forEach(System.out::println);
    }
    public Long getMaxId(){
        return gamers.stream()
                .mapToLong(Gamer::getId)
                .max()
                .orElse(1000000);
    }




}
