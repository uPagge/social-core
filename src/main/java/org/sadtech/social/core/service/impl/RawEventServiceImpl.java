package org.sadtech.social.core.service.impl;

import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadtech.social.core.repository.EventRepository;
import org.sadtech.social.core.service.RawEventService;

import java.util.Queue;

@Slf4j
@RequiredArgsConstructor
public class RawEventServiceImpl implements RawEventService {

    private final EventRepository<JsonObject> eventRepository;

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

}
