package org.sadtech.bot.core.domain;

import org.sadtech.bot.core.domain.attachment.Attachment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Mail extends Content {

    private Integer id;
    private LocalDateTime date;
    private List<Attachment> attachments;

    public Mail() {

    }

    public Mail(Mail source) {
        super(source);
        this.id = source.getId();
        this.date = source.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
                Objects.equals(attachments, mail.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, date, attachments);
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", date=" + date +
                ", attachments=" + attachments +
                '}';
    }
}
