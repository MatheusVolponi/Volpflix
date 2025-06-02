package br.com.Volpflix.models;

import br.com.Volpflix.calculs.Rate;

public class Episode implements Rate {
    private int number;
    private String nome;
    private Serie serie;
    private int totalViews;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    @Override
    public int getRate() {
        if (totalViews > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
