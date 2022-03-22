public class InvoiceLine {
    int amount;
    int volume;
    String playName;
    int audience;
    transient InvoiceLineWriter writer;

    public InvoiceLine(PerformancePlayCalculator calculator) {
        this.amount = calculator.calculateAmount();
        this.volume = calculator.calculateVolumeCredits();
        this.playName = calculator.getPlay().name;
        this.audience = calculator.getPerformance().audience;
        this.writer = new InvoiceLineWriter(this);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
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
