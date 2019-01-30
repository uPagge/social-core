package org.sadtech.vkbot.core.repository.impl;

import com.google.gson.JsonObject;
import org.sadtech.vkbot.core.repository.EventRepository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventRepositoryQueue implements EventRepository<JsonObject> {

    private Queue<JsonObject> jsonObjects = new ConcurrentLinkedQueue<>();

    @Override
    public void add(JsonObject jsonObject) {
        jsonObjects.offer(jsonObject);
    }

    @Override
    public void cleanAll() {
        jsonObjects.clear();
    }

    public Queue<JsonObject> getEventQueue() {
        return jsonObjects;
    }
}
