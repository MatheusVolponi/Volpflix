package br.com.Volpflix.models;

import br.com.Volpflix.calculs.Rate;

public class Film extends Title implements Rate {
    private String director;

    public Film(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //Sistema de 5 estrelas
    @Override
    public int getRate() {
        return (int) avgReviews() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " ( " + this.getReleaseYear() + " ) ";
    }
}
