package org.sadtech.social.core.repository.impl.jpa;

import com.google.gson.JsonObject;
import org.sadtech.social.core.domain.jpa.JsonObjectId;
import org.sadtech.social.core.repository.EventRepository;
import org.sadtech.social.core.repository.jpa.EventRepositoryJpa;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * TODO: Добавить описание класса.
 *
 * @author upagge [28/07/2019]
 */
public class EventRepositoryJpaImpl implements EventRepository<JsonObject> {

    private final EventRepositoryJpa eventRepositoryJpa;

    public EventRepositoryJpaImpl(EventRepositoryJpa eventRepositoryJpa) {
        this.eventRepositoryJpa = eventRepositoryJpa;
    }

    @Override
    public void add(JsonObject dataObject) {
        eventRepositoryJpa.saveAndFlush(new JsonObjectId(dataObject));
    }

    @Override
    public void cleanAll() {
        eventRepositoryJpa.deleteAll();
    }

    @Override
    public Queue<JsonObject> getEventQueue() {
        List<JsonObjectId> allEvent = eventRepositoryJpa.findAll();
        eventRepositoryJpa.deleteAll(allEvent);
        return allEvent.stream().map(JsonObjectId::getJsonObject).collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
    }
}
