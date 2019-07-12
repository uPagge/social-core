package org.sadtech.social.core.domain.content;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sadtech.social.core.domain.content.attachment.Attachment;
import org.sadtech.social.core.utils.Description;

import java.util.List;

/**
 * Сообщение от пользователя типа "Личное сообщение".
 *
 * @author upagge [08/07/2019]
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Mail extends Message {

    @Description("Вложения к сообщению")
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

}
