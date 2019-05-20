package org.sadtech.bot.core.domain;

import java.util.Objects;

public abstract class Content {

    public static final EmptyContent EMPTY_CONTENT = new EmptyContent();

    private Integer personId;
    private String message;

    public Content() {

    }

    public Content(Content source) {
        this.personId = source.getPersonId();
        this.message = source.getMessage();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;
        Content content = (Content) o;
        return Objects.equals(personId, content.personId) &&
                Objects.equals(message, content.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, message);
    }
}
