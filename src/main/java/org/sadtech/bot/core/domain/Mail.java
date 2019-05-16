package org.sadtech.bot.core.domain;

import org.sadtech.bot.core.domain.attachment.Attachment;

import java.util.List;
import java.util.Objects;

public class Mail extends Content {

    private Integer id;
    private Integer date;
    private String message;
    private List<Attachment> attachments;

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

    public Mail prototype() {
        return new Mail(this);
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
