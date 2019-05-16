package org.sadtech.bot.core.service;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService<T> {

    void add(T event);

    List<T> getEvent(LocalDateTime timeFrom, LocalDateTime timeTo);

    List<T> getFirstEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    List<T> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
