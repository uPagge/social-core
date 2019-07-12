package org.sadtech.social.core.service.sender;

import org.sadtech.social.core.domain.BoxAnswer;

/**
 * Интерфейс для отправки ответов пользователю.
 *
 * @author upagge [08/07/2019]
 */
public interface Sent {

    /**
     * Отрпавляет ответ пользователю
     *
     * @param personId  Идентификатор пользователя
     * @param boxAnswer Объект с данными, которые необходимо отправить
     */
    void send(Integer personId, BoxAnswer boxAnswer);

    void send(Integer contentId, Integer personId, BoxAnswer boxAnswer);

}
