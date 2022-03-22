public class PerformancePlayCalculatorTragedy extends PerformancePlayCalculator {
    InvoiceLineWriter writer;

    public PerformancePlayCalculatorTragedy(Play play, Performance performance) {
        super(play, performance);
        writer = new InvoiceLineWriter(this);
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

    public InvoiceLineWriter getWriter() {
        return writer;
    }

    public void setWriter(InvoiceLineWriter writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return writer.toString();
    }
}
