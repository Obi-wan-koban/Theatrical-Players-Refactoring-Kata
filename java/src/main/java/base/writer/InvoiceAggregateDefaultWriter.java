package base.writer;

import base.InvoiceAggregate;

public class InvoiceAggregateDefaultWriter extends InvoiceAggregateAbstractWriter {

    public InvoiceAggregateDefaultWriter(InvoiceAggregate invoiceAggregate) {
        super(invoiceAggregate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Statement for %s\n", invoiceAggregate.getCustomerName()));
        invoiceAggregate.getInvoiceLines().forEach(invoiceLine -> sb.append(invoiceLine));
        sb.append(String.format("Amount owed is %s\n", invoiceAggregate.getTotalAmount()));
        sb.append(String.format("You earned %s credits\n", invoiceAggregate.getVolumeCredits()));
        return sb.toString();
    }

}
