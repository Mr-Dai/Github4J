package com.github4j.json;

import com.google.gson.*;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.lang.reflect.Type;

/**
 * <b>WARNING</b>: do not use this class outside package {@code com.cdf.network}.
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>,
        JsonDeserializer<LocalDateTime> {
    private final DateTimeFormatter iso8601Formatter =
            new DateTimeFormatterBuilder()
                    .appendYear(4, 9).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-')
                    .appendDayOfMonth(2).appendLiteral('T').appendHourOfDay(2).appendLiteral(':')
                    .appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
                    .appendLiteral('Z').toFormatter();

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context)
            throws JsonParseException {
        if (!json.isJsonPrimitive())
            throw new JsonParseException("LocalDateTimeAdapter does not support JSON element `"
                    + json.toString() + "`");
        LocalDateTime result;
        try {
            result = LocalDateTime.parse(json.getAsString(), iso8601Formatter);
        } catch (Exception e) {
            JsonParseException ex = new JsonParseException("LocalDateTimeAdapter failed to parse "
                + "JSON element `" + json.toString() + "`");
            ex.setStackTrace(new StackTraceElement[0]);
            ex.initCause(e);
            throw ex;
        }
        return result;
    }

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return new JsonPrimitive(src.toString(iso8601Formatter));
    }
}
