package org.sadtech.vkbot.core.repository;

import java.util.Queue;

public interface EventRepository<T> {

    void add(T dataObject);

    void cleanAll();

    Queue<T> getEventQueue();

}
