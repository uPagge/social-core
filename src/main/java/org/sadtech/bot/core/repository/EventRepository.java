package org.sadtech.bot.core.repository;

import java.util.Queue;

public interface EventRepository<T> {

    void add(T dataObject);

    void cleanAll();

    Queue<T> getEventQueue();

}
