package org.sadtech.social.core.utils;

import org.sadtech.social.core.domain.content.EmptyMessage;
import org.sadtech.social.core.domain.content.Message;

import static org.sadtech.social.core.utils.ExceptionMessages.UTILITY_CLASS;

/**
 * Класс для хранения объекта заглушки для {@link Message}.
 *
 * @author upagge [08/07/2019]
 */
public class MessageUtils {

    private MessageUtils() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    public static final EmptyMessage EMPTY_MESSAGE = new EmptyMessage();


}
