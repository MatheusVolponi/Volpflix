import br.com.Volpflix.calculs.RecommendationFilter;
import br.com.Volpflix.calculs.TimeCalculation;
import br.com.Volpflix.models.Episode;
import br.com.Volpflix.models.Film;
import br.com.Volpflix.models.Serie;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film();
        myFilm.setName("Star Wars");
        myFilm.setReleaseYear(1977);
        myFilm.setLengthInMinutes(121);
        myFilm.setPlanIncluded(true);

        myFilm.displayTechnicalSheet();
        myFilm.rateMovie(8);
        myFilm.rateMovie(5);
        myFilm.rateMovie(7);

        System.out.println("Total de avaliações: " + myFilm.getTotalReviews());
        System.out.println(myFilm.avgReviews());

        Serie mySerie = new Serie();
        mySerie.setName("South Park");
        mySerie.setReleaseYear(1997);
        mySerie.setSeasons(27);
        mySerie.setEpisodesPerSeason(16);
        mySerie.setMinutesPerEpisode(22);
        mySerie.displayTechnicalSheet();
        System.out.println("Duração da série: " + mySerie.getLengthInMinutes());

        Film myFilm2 = new Film();
        myFilm2.setName("Duna");
        myFilm2.setReleaseYear(2021);
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
    }
}
