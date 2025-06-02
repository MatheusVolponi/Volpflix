package br.com.Volpflix.calculs;

public class RecommendationFilter {
    private String recommendation;

    public void filter(Rate rate) {
        if (rate.getRate() >= 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (rate.getRate() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois.");
        }
    }
}
