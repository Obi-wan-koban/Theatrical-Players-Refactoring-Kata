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
