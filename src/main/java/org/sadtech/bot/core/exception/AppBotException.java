package org.sadtech.bot.core.exception;

import java.time.LocalDateTime;

public class AppBotException extends RuntimeException {

    private static final String TYPE = "ERROR";
    private final LocalDateTime timeError = LocalDateTime.now();
    protected final Integer code;
    protected final String description;

    public AppBotException(Integer code, String message) {
        this.description = message;
        this.code = code;
    }

    public String getType() {
        return TYPE;
    }

    public LocalDateTime getTimeError() {
        return timeError;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
