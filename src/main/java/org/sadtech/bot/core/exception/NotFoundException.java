package org.sadtech.bot.core.exception;

public class NotFoundException extends AppBotException {
    public NotFoundException(Integer code, String message) {
        super(code, message);
    }
}
