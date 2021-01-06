package com.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtils {

    private static JsonParser jsonParser = new JsonParser();
    private static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    private static Gson gson = new Gson();


    public static String pretty(Object object) {

        return pretty(toJsonString(object));
    }

    public static String pretty(String jsonString) {

        try {
            return pretty(jsonParser.parse(jsonString).getAsJsonObject());
        } catch (IllegalStateException e) {
            return pretty(jsonParser.parse(jsonString).getAsJsonArray());
        }
    }

    public static String pretty(JsonElement jsonElement) {

        return prettyGson.toJson(jsonElement);
    }

    public static String toJsonString(Object object){
        return gson.toJson(object);
    }
}
