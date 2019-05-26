package org.sadtech.bot.core.exception;

public class AccessException extends AppBotException {
    public AccessException(Integer code, String message) {
        super(code, message);
    }
}
