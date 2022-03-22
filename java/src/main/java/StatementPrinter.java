import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            PerformancePlayCalculator performancePlayCalculator = null;
            var thisAmount = 0;

            switch (play.type) {
                case "tragedy":
                    performancePlayCalculator = new PerformancePlayCalculatorTragedy(play, perf);
                    break;
                case "comedy":
                    performancePlayCalculator = new PerformancePlayCalculatorComedy(play, perf);
                    break;
                default:
                    throw new Error("unknown type: ${play.type}");
            }
            thisAmount += performancePlayCalculator.calculateAmount();
            // add volume credits
            volumeCredits += performancePlayCalculator.calculateVolumeCredits();

            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience);
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

}
