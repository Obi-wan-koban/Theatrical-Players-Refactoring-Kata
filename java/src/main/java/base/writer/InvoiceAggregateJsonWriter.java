package base.writer;

import base.InvoiceAggregate;
import com.google.gson.Gson;

public class InvoiceAggregateJsonWriter extends InvoiceAggregateAbstractWriter{

    public InvoiceAggregateJsonWriter(InvoiceAggregate invoiceAggregate) {
        super(invoiceAggregate);
    }

    @Override
    public String toString() {
        return new Gson().toJson(invoiceAggregate);
    }

}
