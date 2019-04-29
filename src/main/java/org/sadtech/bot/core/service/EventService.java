package org.sadtech.bot.core.service;

import java.util.List;

public interface EventService<T> {

    void add(T event);

    List<T> getEvent(Integer timeFrom, Integer timeTo);

    List<T> getFirstEventByTime(Integer timeFrom, Integer timeTo);

    List<T> getLastEventByTime(Integer timeFrom, Integer timeTo);

}
