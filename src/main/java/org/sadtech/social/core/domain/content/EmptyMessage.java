package org.sadtech.social.core.domain.content;

import lombok.ToString;
import org.sadtech.social.core.exception.AppBotException;

/**
 * Заглушка для сообщения от пользователя.
 *
 * @author upagge [08/07/2019]
 */
@ToString
public class EmptyMessage extends Message {

    public EmptyMessage() {
        type = ContentType.EMPTY;
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public void setText(String text) {
        throw new AppBotException("EmptyMessage no setText");
    }

}
