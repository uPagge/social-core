package org.sadtech.social.core.service;

import org.sadtech.social.core.domain.content.Message;

/**
 * Интерфес для изменения запроса пользователя перед тем, как он попадет в подсистему обработки.
 * Например можно исправить опечатки, перевести сообщение на другой язык и так далее.
 *
 * @author upagge [08/07/2019]
 */
@FunctionalInterface
public interface Filter<T extends Message> {

    void processing(T content);

}
