package org.sadtech.vkbot.core.distribution.impl;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.distribution.EventDistributable;
import org.sadtech.vkbot.core.distribution.EventSubscribe;
import org.sadtech.vkbot.core.service.EventService;

import java.util.HashMap;
import java.util.Map;

public class EventDistributorVK implements EventDistributable, Runnable {

    public static final Logger log = Logger.getLogger(EventDistributorVK.class);

    private EventService eventService;
    private Map<String, EventSubscribe> eventDistributionMap = new HashMap<>();

    public EventDistributorVK(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void distribute() {
        while (true) {
            if (eventService.getJsonObjects().peek() != null) {
                JsonObject event = eventService.getJsonObjects().poll();
                log.info("Главный дистрибьютор отправил событие дальше");
                eventDistributionMap.get(event.get("type").toString()).update(event);

            }
        }
    }

    @Override
    public void registerSubscriber(String key, EventSubscribe o) {
        eventDistributionMap.put(key, o);
    }

    @Override
    public void run() {
        distribute();
    }
}
