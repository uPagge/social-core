package org.sadtech.social.core.utils;

import org.sadtech.social.core.domain.content.EmptyMessage;
import org.sadtech.social.core.domain.content.Message;

/**
 * Класс для хранения объекта заглушки для {@link Message}.
 *
 * @author upagge [08/07/2019]
 */
public class MessageUtils {

    public static final EmptyMessage EMPTY_MESSAGE = new EmptyMessage();

    private MessageUtils() {
        throw new IllegalStateException(Messages.UTILITY_CLASS);
    }

}
