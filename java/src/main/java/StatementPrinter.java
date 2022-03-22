import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementPrinter {
    PerformancePlayFactory factory = new PerformancePlayFactory();

    public String print(Invoice invoice, Map<String, Play> plays) {
        AtomicInteger totalAmount = new AtomicInteger(0);
        AtomicInteger volumeCredits = new AtomicInteger(0);
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        invoice.performances.forEach(performance ->  {
            var play = plays.get(performance.playID);
            PerformancePlayCalculator performancePlayCalculator = factory.createPerformancePlayCalculator(play, performance);
            InvoiceLine invoiceLine = new InvoiceLine(performancePlayCalculator);
            totalAmount.addAndGet(invoiceLine.getAmount());
            volumeCredits.addAndGet(invoiceLine.getVolume());
            result.append(invoiceLine);
        });

        result.append(String.format("Amount owed is %s\n", InvoiceLineWriter.frmt.format(totalAmount.get() / 100)));
        result.append(String.format("You earned %s credits\n", volumeCredits.get()));
        return result.toString();
    }

}
