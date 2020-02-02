package org.sadtech.social.core.exception;

import java.time.LocalDateTime;

/**
 * Родитель всех исключений библиотеки.
 *
 * @author upagge [08/07/2019]
 */
public class AppBotException extends RuntimeException {

    private static final String TYPE = "ERROR";
    private final LocalDateTime timeError = LocalDateTime.now();
    protected String description;

    public AppBotException(String message) {
        super(message);
    }

    public AppBotException(String message, String description) {
        super(message);
        this.description = description;
    }

    public String getType() {
        return TYPE;
    }

    public LocalDateTime getTimeError() {
        return timeError;
    }

    public String getDescription() {
        return description;
    }
}
