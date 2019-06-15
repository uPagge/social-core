package org.sadtech.bot.core.domain.content;

import org.sadtech.bot.core.exception.AppBotException;

public class EmptyMessage extends Message {

    public EmptyMessage() {
        type = ContentType.EMPTY;
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void setMessage(String message) {
        throw new AppBotException(0, "EmptyMessage no setMessage");
    }
}
