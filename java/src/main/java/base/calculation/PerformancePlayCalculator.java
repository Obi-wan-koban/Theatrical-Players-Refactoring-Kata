package base.calculation;

import base.Performance;
import base.Play;

public abstract class PerformancePlayCalculator {
    Play play;
    Performance performance;

    public PerformancePlayCalculator(Play play, Performance performance) {
        this.play = play;
        this.performance = performance;
    }

    public abstract int calculateAmount();
    public abstract int calculateVolumeCredits();

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
