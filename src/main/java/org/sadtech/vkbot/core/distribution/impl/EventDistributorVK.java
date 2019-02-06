package org.sadtech.vkbot.core.distribution.impl;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.distribution.EventDistributable;
import org.sadtech.vkbot.core.distribution.EventSubscribe;
import org.sadtech.vkbot.core.service.RawEventService;

import java.util.HashMap;
import java.util.Map;

public class EventDistributorVK implements EventDistributable, Runnable {

    public static final Logger log = Logger.getLogger(EventDistributorVK.class);

    private RawEventService rawEventService;
    private Map<String, EventSubscribe> eventDistributionMap = new HashMap<>();

    public EventDistributorVK(RawEventService rawEventService) {
        this.rawEventService = rawEventService;
    }

    @Override
    public void distribute() {
        while (true) {
            if (rawEventService.getJsonObjects().peek() != null) {
                JsonObject event = rawEventService.getJsonObjects().poll();
                log.info("Главный дистрибьютор отправил событие дальше");
                if (eventDistributionMap.containsKey(event.get("type").getAsString())) {
                    eventDistributionMap.get(event.get("type").getAsString()).update(event.getAsJsonObject("object"));
                }
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
