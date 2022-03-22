import com.google.gson.GsonBuilder;

public class InvoiceLineJsonWriter extends InvoiceLineWriter{

    public InvoiceLineJsonWriter(InvoiceLine invoiceLine) {
        super(invoiceLine);
    }

    @Override
    public String toString() {
        return new GsonBuilder().registerTypeAdapter(InvoiceLineSerializer.class, new InvoiceLineSerializer()).create().toJson(invoiceLine);
    }

}
