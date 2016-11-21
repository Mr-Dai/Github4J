package com.github4j.json;

import com.google.gson.*;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private final DateTimeFormatter iso8601Formatter = ISODateTimeFormat.date();

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT,
                                 JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonPrimitive())
            throw new JsonParseException("LocalDateAdapter does not support JSON element `"
                    + json.toString() + "`");
        LocalDate result;
        try {
            result = LocalDate.parse(json.getAsString(), iso8601Formatter);
        } catch (Exception e) {
            JsonParseException ex = new JsonParseException("LocalDateAdapter failed to parse "
                    + "JSON element `" + json.toString() + "`");
            ex.setStackTrace(new StackTraceElement[0]);
            ex.initCause(e);
            throw ex;
        }
        return result;
    }

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return new JsonPrimitive(src.toString(iso8601Formatter));
    }
}
