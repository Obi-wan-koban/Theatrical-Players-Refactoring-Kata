package base.factory;

import base.Performance;
import base.Play;
import base.calculation.PerformancePlayCalculator;
import base.calculation.PerformancePlayCalculatorComedy;
import base.calculation.PerformancePlayCalculatorTragedy;

public class PerformancePlayFactory {

    public PerformancePlayCalculator createPerformancePlayCalculator(Play play, Performance performance) {
        switch (play.type) {
            case "tragedy":
                return new PerformancePlayCalculatorTragedy(play, performance);
            case "comedy":
                return new PerformancePlayCalculatorComedy(play, performance);
            default:
                throw new Error("unknown type: ${play.type}");
        }
    }
}
