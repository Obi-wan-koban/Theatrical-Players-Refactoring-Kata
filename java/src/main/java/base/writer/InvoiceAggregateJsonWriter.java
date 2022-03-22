package base.writer;

import base.InvoiceAggregate;
import base.InvoiceLine;
import base.serializer.InvoiceLineSerializer;
import com.google.gson.GsonBuilder;

public class InvoiceAggregateJsonWriter extends InvoiceAggregateAbstractWriter{

    public InvoiceAggregateJsonWriter(InvoiceAggregate invoiceAggregate) {
        super(invoiceAggregate);
    }

    @Override
    public String toString() {
        return new GsonBuilder().registerTypeAdapter(InvoiceLine.class, new InvoiceLineSerializer()).create().toJson(invoiceAggregate);
    }

}
