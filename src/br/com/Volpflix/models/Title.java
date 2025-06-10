package br.com.Volpflix.models;

import br.com.Volpflix.exceptions.YearConversionErrorException;

public class Title implements Comparable<Title>{
    private String name;
    private int releaseYear;
    private boolean planIncluded;
    private double review; // soma das Avaliações
    private int totalReviews; // Total de avaliaçoes
    private int lengthInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OmdbTitle myTitleOMDB) {
        this.name = myTitleOMDB.title();

        if(myTitleOMDB.year().length() > 4) {
            throw new YearConversionErrorException("Não foi possível converter o ano porque há mais de 04 caractéres.");
        }
        this.releaseYear = Integer.valueOf(myTitleOMDB.year());
        this.lengthInMinutes = Integer.valueOf(myTitleOMDB.Runtime().substring(0,3));
    }

    public void displayTechnicalSheet(){
        System.out.println("Título: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
        System.out.println("Duração em minutos: " + lengthInMinutes);
        System.out.println("Incluído no plano: " + planIncluded);
    }

    // Funçao para avaliação
    public void rateMovie(double rate){
        review += rate;
        totalReviews++;
    }

    // Média das avaliações
    public double avgReviews(){
        return review / totalReviews;
    }

    public int getTotalReviews(){
        return totalReviews;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getName() {
        return name;
    }

    public boolean isPlanIncluded() {
        return planIncluded;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanIncluded(boolean planIncluded) {
        this.planIncluded = planIncluded;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "[Nome: " + name + ", Ano de lançamento: " + releaseYear + ", Duração: " + lengthInMinutes + "]";
    }
}
