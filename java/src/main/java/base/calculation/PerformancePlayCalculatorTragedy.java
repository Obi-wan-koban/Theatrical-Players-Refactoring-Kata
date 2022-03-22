package base.calculation;

import base.Performance;
import base.Play;

public class PerformancePlayCalculatorTragedy extends PerformancePlayCalculator {

    public PerformancePlayCalculatorTragedy(Play play, Performance performance) {
        super(play, performance);
    }

    @Override
    public int calculateAmount() {
        int thisAmount = 40000;
        if (getPerformance().audience > 30) {
            thisAmount += 1000 * (getPerformance().audience - 30);
        }
        return thisAmount;
    }

    @Override
    public int calculateVolumeCredits() {
        return Math.max(getPerformance().audience - 30, 0);
    }

}
