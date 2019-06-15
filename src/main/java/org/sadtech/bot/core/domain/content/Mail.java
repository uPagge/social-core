package org.sadtech.bot.core.domain.content;

import org.sadtech.bot.core.domain.content.attachment.Attachment;

import java.util.List;
import java.util.Objects;

public class Mail extends Message {

    private List<Attachment> attachments;

    public Mail() {
        type = ContentType.MAIL;
    }

    public Mail(Mail source) {
        super(source);
        this.attachments = source.getAttachments();
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
        return Objects.equals(attachments, mail.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attachments);
    }

    @Override
    public String toString() {
        return "Mail{" +
                "attachments=" + attachments +
                ", type=" + type +
                '}';
    }
}
