package org.sadtech.social.core.domain.content;

import lombok.Data;
import org.sadtech.social.core.utils.Description;

import java.time.LocalDateTime;

/**
 * Аьстрактная сущность - Сообщение от пользователя.
 *
 * @author upagge [08/07/2019]
 */
@Data
public abstract class Message {

    @Description("Идентификатор сообщения")
    private Integer id;

    @Description("Тип сообщения")
    protected ContentType type;

    @Description("Дата создания")
    private LocalDateTime createDate;

    @Description("Идентификатор пользователя, отправившего сообщение")
    private Integer personId;

    @Description("Текстовое сообщение")
    private String text;

    public Message() {

    }

    public Message(Message source) {
        this.personId = source.getPersonId();
        this.text = source.getText();
        this.createDate = source.getCreateDate();
        this.id = source.getPersonId();
        this.type = source.getType();
    }

}
