package br.com.Volpflix.main;

import br.com.Volpflix.models.Film;
import br.com.Volpflix.models.Serie;
import br.com.Volpflix.models.Title;

import java.util.*;

public class MainLists {
    public static void main(String[] args) {
        Film myFilm = new Film("Star Wars", 1977);
        myFilm.rateMovie(9);
        myFilm.rateMovie(8);
        Film myFilm2 = new Film("Duna", 2021);
        myFilm2.rateMovie(10);
        myFilm2.rateMovie(9);
        Film myFilm3 = new Film("Lilo e Stitch", 2025);
        myFilm3.rateMovie(8);
        myFilm3.rateMovie(6);
        Serie mySerie = new Serie("South Park", 1997);

        List<Title> watchedList = new LinkedList<>();
        watchedList.add(myFilm3);
        watchedList.add(myFilm);
        watchedList.add(myFilm2);
        watchedList.add(mySerie);

        for (Title item: watchedList){
            System.out.println(item.getName());
            if (item instanceof Film film && film.getRate() > 2) {
                System.out.println("Classificação: " + film.getRate());
            }
        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Timothée Chalamet");
        searchByArtist.add("Bryan Cranston");
        searchByArtist.add("Oscar Isaac");
        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println("Depois da ordenação: ");
        System.out.println(searchByArtist);

        System.out.println("Lista de títulos em ordem Alfabética:");
        Collections.sort(watchedList);
        System.out.println(watchedList);
        watchedList.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Ordenando por ano:");
        System.out.println(watchedList);
    }
}
