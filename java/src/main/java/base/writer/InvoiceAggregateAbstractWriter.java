package base.writer;

import base.InvoiceAggregate;

public abstract class InvoiceAggregateAbstractWriter {
    InvoiceAggregate invoiceAggregate;
    public InvoiceAggregateAbstractWriter(InvoiceAggregate invoiceAggregate) {
        this.invoiceAggregate = invoiceAggregate;
    }

    @Override
    public abstract String toString();

    public InvoiceAggregate getInvoiceAggregate() {
        return invoiceAggregate;
    }

    public void setInvoiceAggregate(InvoiceAggregate invoiceAggregate) {
        this.invoiceAggregate = invoiceAggregate;
    }
}
