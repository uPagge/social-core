package org.sadtech.vkbot.core.service.impl;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.repository.EventRepository;
import org.sadtech.vkbot.core.service.RawEventService;

import java.util.Queue;

public class RawEventServiceImpl implements RawEventService {

    public static final Logger log = Logger.getLogger(RawEventServiceImpl.class);

    private EventRepository eventRepository;

    public RawEventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void cleanAll() {
        eventRepository.cleanAll();
        log.info("Репозиторий событий очищен");
    }

    @Override
    public void add(JsonObject jsonObject) {
        eventRepository.add(jsonObject);
        log.info("Событие отправленно в репозиторий");
    }

    @Override
    public Queue<JsonObject> getJsonObjects() {
        return eventRepository.getEventQueue();
    }

    @Override
    public EventRepository getEventRepository() {
        return eventRepository;
    }

    @Override
    public void replacementEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
