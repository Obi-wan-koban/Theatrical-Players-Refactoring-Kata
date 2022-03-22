package base.writer;

import base.InvoiceLine;

public abstract class InvoiceLineAbstractWriter {
    InvoiceLine invoiceLine;

    public InvoiceLineAbstractWriter(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
    @Override
    public abstract String toString();

    public InvoiceLine getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}
