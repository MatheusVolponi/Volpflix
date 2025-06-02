package br.com.Volpflix.models;

import br.com.Volpflix.calculs.Rate;

public class Film extends Title implements Rate {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRate() {
        return (int) avgReviews() / 2;
    }
}
