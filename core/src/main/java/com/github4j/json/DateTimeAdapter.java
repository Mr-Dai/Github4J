package com.github4j.json;

import com.google.gson.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.lang.reflect.Type;

public class DateTimeAdapter implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
    private final DateTimeFormatter iso8601Formatter =
            new DateTimeFormatterBuilder()
                    .appendYear(4, 9).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-')
                    .appendDayOfMonth(2).appendLiteral('T').appendHourOfDay(2).appendLiteral(':')
                    .appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
                    .appendTimeZoneOffset("Z", true, 2, 2).toFormatter();

    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonPrimitive())
            throw new JsonParseException("DateTimeAdapter does not support JSON element `"
                    + json.toString() + "`");
        DateTime result;
        try {
            result = DateTime.parse(json.getAsString(), iso8601Formatter);
        } catch (Exception e) {
            JsonParseException ex = new JsonParseException("DateTimeAdapter failed to parse "
                    + "JSON element `" + json.toString() + "`");
            ex.setStackTrace(new StackTraceElement[0]);
            ex.initCause(e);
            throw ex;
        }
        return result;
    }

    @Override
    public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString(iso8601Formatter));
    }
}
