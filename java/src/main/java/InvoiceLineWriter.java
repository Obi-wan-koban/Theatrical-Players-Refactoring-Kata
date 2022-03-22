import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceLineWriter {
    PerformancePlayCalculator performancePlayCalculator;
    public static NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    public InvoiceLineWriter(PerformancePlayCalculator performancePlayCalculator) {
        this.performancePlayCalculator = performancePlayCalculator;
    }

    @Override
    public String toString() {
        return String.format("  %s: %s (%s seats)\n", performancePlayCalculator.getPlay(), frmt.format(getPerformancePlayCalculator().calculateAmount() / 100), getPerformancePlayCalculator().getPerformance().audience);
    }

    public PerformancePlayCalculator getPerformancePlayCalculator() {
        return performancePlayCalculator;
    }

    public void setPerformancePlayCalculator(PerformancePlayCalculator performancePlayCalculator) {
        this.performancePlayCalculator = performancePlayCalculator;
    }
}
