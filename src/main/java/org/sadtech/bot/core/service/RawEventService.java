package org.sadtech.bot.core.service;

import com.google.gson.JsonObject;

import java.util.Queue;

public interface RawEventService {

    void cleanAll();

    void add(JsonObject jsonObject);

    Queue<JsonObject> getJsonObjects();

}