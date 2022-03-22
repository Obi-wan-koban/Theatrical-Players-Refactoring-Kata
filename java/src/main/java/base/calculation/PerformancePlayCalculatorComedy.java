package base.calculation;

import base.Performance;
import base.Play;

public class PerformancePlayCalculatorComedy extends PerformancePlayCalculator {

    public PerformancePlayCalculatorComedy(Play play, Performance performance) {
        super(play, performance);
    }

    @Override
    public int calculateAmount() {
        int thisAmount = 30000;
        if (getPerformance().audience > 20) {
            thisAmount += 10000 + 500 * (getPerformance().audience - 20);
        }
        return thisAmount += 300 * getPerformance().audience;
    }

    @Override
    public int calculateVolumeCredits() {
        // add volume credits
        int volumeCredits = Math.max(getPerformance().audience - 30, 0);
        // add extra credit for every ten comedy attendees
        return volumeCredits += Math.floor(getPerformance().audience / 5);
    }
}
