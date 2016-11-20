package com.github4j.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public abstract class GithubGson {
    private static Gson instance;

    public static synchronized Gson singleton() {
        if (instance == null)
            instance = get();
        return instance;
    }

    public static Gson get() {
        return new GsonBuilder().setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }
}
