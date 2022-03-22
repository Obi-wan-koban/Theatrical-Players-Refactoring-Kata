package base.writer;

import base.InvoiceLine;
import com.google.gson.Gson;

public class InvoiceLineJsonWriter extends InvoiceLineAbstractWriter{

    public InvoiceLineJsonWriter(InvoiceLine invoiceLine) {
        super(invoiceLine);
    }

    @Override
    public String toString() {
        return new Gson().toJson(getInvoiceLine());
    }

}
