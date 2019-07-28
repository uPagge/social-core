package org.sadtech.social.core.repository;

import org.sadtech.social.core.domain.content.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс взаимодействия со всеми наследниками текстовых запросов пользователей.
 *
 * @author upagge [08/07/2019]
 */
public interface ContentRepository<T extends Message> {

    /**
     * Добавить сообщение в хранилище
     *
     * @param content Объект сообщени
     * @return Идентификатор сообщения в хранилище
     */
    Integer add(T content);

    /**
     * Получить все сообщения за определенный временной диапазон
     *
     * @param timeFrom Начало временного диапазона
     * @param timeTo   Конец диапазона
     * @return Список сообщений
     */
    List<T> betweenByTime(LocalDateTime timeFrom, LocalDateTime timeTo);

}
