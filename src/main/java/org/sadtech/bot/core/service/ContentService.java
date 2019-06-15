package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.content.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface ContentService<T extends Message> {

    void add(T event);

    List<T> getByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    List<T> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
