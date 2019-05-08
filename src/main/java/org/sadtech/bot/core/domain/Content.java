package org.sadtech.bot.core.domain;

import java.util.Objects;

public abstract class Content {

    private Integer personId;

    public Content() {

    }

    public Content(Content source) {
        this.personId = source.getPersonId();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;
        Content content = (Content) o;
        return Objects.equals(personId, content.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}
