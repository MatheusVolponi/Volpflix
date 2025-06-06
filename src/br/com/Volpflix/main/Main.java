package br.com.Volpflix.main;

import br.com.Volpflix.calculs.RecommendationFilter;
import br.com.Volpflix.calculs.TimeCalculation;
import br.com.Volpflix.models.Episode;
import br.com.Volpflix.models.Film;
import br.com.Volpflix.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film("Star Wars", 1977);
        myFilm.setLengthInMinutes(121);
        myFilm.setPlanIncluded(true);

        myFilm.displayTechnicalSheet();
        myFilm.rateMovie(8);
        myFilm.rateMovie(5);
        myFilm.rateMovie(7);

        System.out.println("Total de avaliações: " + myFilm.getTotalReviews());
        System.out.println(myFilm.avgReviews());

        Serie mySerie = new Serie("South Park", 1997);
        mySerie.setSeasons(27);
        mySerie.setEpisodesPerSeason(16);
        mySerie.setMinutesPerEpisode(22);
        mySerie.displayTechnicalSheet();
        System.out.println("Duração da série: " + mySerie.getLengthInMinutes());

        Film myFilm2 = new Film("Duna", 2021);
        myFilm2.setLengthInMinutes(155);

        TimeCalculation calculadora = new TimeCalculation();
        calculadora.includeTitle(myFilm);
        calculadora.includeTitle(myFilm2);
        calculadora.includeTitle(mySerie);
        System.out.println(calculadora.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(myFilm);
        filter.filter(myFilm2);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(mySerie);
        episode.setTotalViews(300);
        filter.filter(episode);

        Film myFilm3 = new Film("Lilo e Stitch", 2025);
        myFilm3.setLengthInMinutes(108);
        myFilm3.rateMovie(9);

        ArrayList<Film> listOfMovies = new ArrayList<>();
        listOfMovies.add(myFilm3);
        listOfMovies.add(myFilm);
        listOfMovies.add(myFilm2);
        System.out.println("Tamanho da lista: " + listOfMovies.size());
        System.out.println("Primeiro Filme: " + listOfMovies.get(0).getName());
        System.out.println("Primeiro " + listOfMovies.get(0).toString());
        System.out.println(listOfMovies);

    }
}
