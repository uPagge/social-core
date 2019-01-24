package org.sadtech.vkbot.core.repository.impl;

import com.google.gson.JsonObject;
import org.sadtech.vkbot.core.repository.EventRepository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventRepositoryQueue implements EventRepository {

    private Queue<JsonObject> jsonObjects = new ConcurrentLinkedQueue<>();

    @Override
    public void add(JsonObject jsonObject) {
        jsonObjects.offer(jsonObject);
    }

    @Override
    public void remove(int id) {
        jsonObjects.remove(id);
    }

    @Override
    public void cleanAll() {
        jsonObjects.clear();
    }

    public Queue<JsonObject> getJsonObjects() {
        return jsonObjects;
    }
}
