package org.sadtech.vkbot.core.service.distribution.impl;

import java.util.List;

public interface EventService<T> {

    void add(T event);

    List<T> getEvent(Integer timeFrom, Integer timeTo);

    List<T> getFirstMailByTime(Integer timeFrom, Integer timeTo);

    List<T> getLastMailByTime(Integer timeFrom, Integer timeTo);

}
