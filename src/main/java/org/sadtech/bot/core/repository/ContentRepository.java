package org.sadtech.bot.core.repository;

import org.sadtech.bot.core.domain.content.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface ContentRepository<T extends Message> {

    Integer add(T content);

    List<T> findByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
