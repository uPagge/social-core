package org.sadtech.vkbot.core.service.handlers;

import java.util.List;

public interface SortEventService<T> {

    List<T> getEvent(Integer timeFrom, Integer timeTo);

    List<T> getFirstMailByTime(Integer timeFrom, Integer timeTo);

    List<T> getLastMailByTime(Integer timeFrom, Integer timeTo);

}
