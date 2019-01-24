package org.sadtech.vkbot.core.repository;

import com.google.gson.JsonObject;

import java.util.Queue;

public interface EventRepository {

    void add(JsonObject jsonObject);

    void remove(int id);

    void cleanAll();

    Queue<JsonObject> getJsonObjects();

}
