package org.sadtech.bot.core.domain.content;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Content {

    private Integer id;
    protected ContentType type;
    private LocalDateTime createDate;
    private Integer personId;
    private String message;

    public Content() {

    }

    public Content(Content source) {
        this.personId = source.getPersonId();
        this.message = source.getMessage();
        this.createDate = source.getCreateDate();
        this.id = source.getPersonId();
        this.type = source.getType();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;
        Content content = (Content) o;
        return Objects.equals(id, content.id) &&
                type == content.type &&
                Objects.equals(createDate, content.createDate) &&
                Objects.equals(personId, content.personId) &&
                Objects.equals(message, content.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, createDate, personId, message);
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", type=" + type +
                ", createDate=" + createDate +
                ", personId=" + personId +
                ", message='" + message + '\'' +
                '}';
    }
}
