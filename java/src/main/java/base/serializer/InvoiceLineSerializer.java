package base.serializer;

import base.InvoiceLine;
import base.writer.InvoiceLineDefaultWriter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class InvoiceLineSerializer implements JsonSerializer<InvoiceLine> {
    @Override
    public JsonElement serialize(InvoiceLine src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty( "playName", src.getPlayName());
        String formattedAmount = InvoiceLineDefaultWriter.frmt.format(src.getAmount() / 100);
        json.addProperty("amount", "formattedAmount");
        json.addProperty("audience", src.getAudience());
        json.addProperty( "volumeCredits", src.getVolume());
        return json;
    }
}
