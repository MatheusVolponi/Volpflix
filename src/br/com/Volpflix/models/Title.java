package br.com.Volpflix.models;

public class Title {
    private String name;
    private int releaseYear;
    private boolean planIncluded;
    private double review; // soma das Avaliações
    private int totalReviews; // Total de avaliaçoes
    private int lengthInMinutes;

    public void displayTechnicalSheet(){
        System.out.println("Título: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
        System.out.println("Duração em minutos: " + lengthInMinutes);
        System.out.println("Incluído no plano: " + planIncluded);
    }

    public void rateMovie(double rate){
        review += rate;
        totalReviews++;
    }

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
}
