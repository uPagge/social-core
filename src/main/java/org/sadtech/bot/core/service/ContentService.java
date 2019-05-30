package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.content.Content;

import java.time.LocalDateTime;
import java.util.List;

public interface ContentService<T extends Content> {

    void add(T event);

    List<T> getByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

    List<T> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
