package org.sadtech.social.core.repository;

import java.util.Queue;

/**
 * Обработка событий социальной сети.
 *
 * @author upagge [08/07/2019]
 */
public interface EventRepository<T> {

    void add(T dataObject);

    void cleanAll();

    Queue<T> getEventQueue();

}
