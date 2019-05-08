package org.sadtech.bot.core.domain;

import java.util.Objects;

public class Mail extends Content {

    private Integer id;
    private Integer date;
    private String message;

    public Mail() {

    }

    public Mail(Mail source) {
        super(source);
        this.id = source.getId();
        this.date = source.getDate();
        this.message = source.getMessage();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Mail clone() {
        return new Mail(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mail)) return false;
        if (!super.equals(o)) return false;
        Mail mail = (Mail) o;
        return Objects.equals(id, mail.id) &&
                Objects.equals(date, mail.date) &&
                Objects.equals(message, mail.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, date, message);
    }
}
