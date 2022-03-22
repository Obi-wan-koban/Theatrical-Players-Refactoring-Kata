package base;

import base.writer.InvoiceAggregateAbstractWriter;
import base.writer.InvoiceAggregateDefaultWriter;

import java.util.List;

public class InvoiceAggregate {
    String totalAmount;
    int volumeCredits;
    String customerName;
    List<InvoiceLine> invoiceLines;
    transient InvoiceAggregateAbstractWriter writer;

    public InvoiceAggregate(String totalAmount, int volumeCredits, String customerName, List<InvoiceLine> invoiceLines) {
        this.totalAmount = totalAmount;
        this.volumeCredits = volumeCredits;
        this.customerName = customerName;
        this.invoiceLines = invoiceLines;
        this.writer = new InvoiceAggregateDefaultWriter(this);
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(int volumeCredits) {
        this.volumeCredits = volumeCredits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public InvoiceAggregateAbstractWriter getWriter() {
        return writer;
    }

    public void setWriter(InvoiceAggregateAbstractWriter writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return writer.toString();
    }
}
