package base.writer;

import base.InvoiceLine;

import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceLineDefaultWriter extends InvoiceLineAbstractWriter {
    public static NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    public InvoiceLineDefaultWriter(InvoiceLine invoiceLine) {
        super(invoiceLine);
    }

    @Override
    public String toString() {
        return String.format("  %s: %s (%s seats)\n", invoiceLine.getPlayName(), invoiceLine.getAmount() , invoiceLine.getAudience());
    }

}
