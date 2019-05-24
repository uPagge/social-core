package org.sadtech.bot.core.domain;

import org.sadtech.bot.core.domain.content.Content;
import org.sadtech.bot.core.exception.AppBotException;

public class EmptyContent extends Content {

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void setMessage(String message) {
        throw new AppBotException(0, "EmptyContent no setMessage");
    }
}
