package br.com.Volpflix.calculs;

import br.com.Volpflix.models.Title;

public class TimeCalculation {
    private int totalTime;

    public void includeTitle(Title title) {
        this.totalTime += title.getLengthInMinutes();
    }

    public int getTotalTime() {
        return totalTime;
    }
}
