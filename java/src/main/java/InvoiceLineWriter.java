import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceLineWriter {
    InvoiceLine invoiceLine;
    public static NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    public InvoiceLineWriter(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    @Override
    public String toString() {
        return String.format("  %s: %s (%s seats)\n", invoiceLine.getPlayName(), frmt.format(invoiceLine.getAmount() / 100), invoiceLine.getAudience());
    }

    public InvoiceLine getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}
