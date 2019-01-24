package org.sadtech.vkbot.core.handlers.impl;

import com.google.gson.JsonObject;
import org.sadtech.vkbot.core.handlers.Handled;
import org.sadtech.vkbot.core.handlers.ProcessableEvent;
import org.sadtech.vkbot.core.service.EventService;

import java.util.HashMap;
import java.util.Map;

public class DispatcherHandlerVk implements Handled, Runnable {

    private EventService responsibleService;
    private Map<String, ProcessableEvent> processableEventMap = new HashMap<>();

    public DispatcherHandlerVk(EventService responsibleService) {
        this.responsibleService = responsibleService;
    }

    @Override
    public void sortAndSend() {
        while (true) {
            if (responsibleService.getJsonObjects().peek() != null) {
                JsonObject event = responsibleService.getJsonObjects().poll();
                processableEventMap.get(event.get("type").toString()).update(event);
            }
        }
    }

    @Override
    public void registerObserver(String key, ProcessableEvent o) {
        processableEventMap.put(key, o);
    }

    @Override
    public EventService getResponsibleService() {
        return responsibleService;
    }

    @Override
    public void run() {
        sortAndSend();
    }
}
