package org.sadtech.social.core.service;

import lombok.NonNull;
import org.sadtech.social.core.domain.content.Message;

/**
 * Интерфес для изменения запроса пользователя перед тем, как он попадет в подсистему обработки.
 * Например можно исправить опечатки, перевести сообщение на другой язык и так далее.
 *
 * @author upagge [08/07/2019]
 */
@FunctionalInterface
public interface Modifiable<T extends Message> {

    void change(@NonNull T content);

}
