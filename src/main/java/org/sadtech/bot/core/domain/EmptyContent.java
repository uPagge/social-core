package org.sadtech.bot.core.domain;

public class EmptyContent extends Content {

    public EmptyContent() {

    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void setMessage(String message) {

    }
}
