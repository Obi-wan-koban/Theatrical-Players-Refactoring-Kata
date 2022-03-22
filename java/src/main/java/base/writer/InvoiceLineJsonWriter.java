package base.writer;

import base.InvoiceLine;
import base.serializer.InvoiceLineSerializer;
import com.google.gson.GsonBuilder;

public class InvoiceLineJsonWriter extends InvoiceLineAbstractWriter{

    public InvoiceLineJsonWriter(InvoiceLine invoiceLine) {
        super(invoiceLine);
    }

    @Override
    public String toString() {
        return new GsonBuilder().registerTypeAdapter(InvoiceLine.class, new InvoiceLineSerializer()).create().toJson(getInvoiceLine());
    }

}
