package org.sadtech.bot.core.exception;

import java.time.LocalDateTime;

public class AppBotException extends RuntimeException {

    private final String type = "ERROR";
    private final LocalDateTime timeError = LocalDateTime.now();
    protected Integer code;
    protected String description;

    public AppBotException(String message, Integer code) {
        super(message);
        this.description = message;
        this.code = code;
    }

    public AppBotException(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
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
