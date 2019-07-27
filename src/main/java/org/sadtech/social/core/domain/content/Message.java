package org.sadtech.social.core.domain.content;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.sadtech.social.core.utils.Description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Аьстрактная сущность - Сообщение от пользователя.
 *
 * @author upagge [08/07/2019]
 */
@Data
@Entity
public abstract class Message {

    @Id
    @GeneratedValue
    @Description("Идентификатор сообщения")
    private Integer id;

    @Description("Тип сообщения")
    protected ContentType type;

    @NotNull
    @Description("Дата создания")
    private LocalDateTime createDate;

    @NotNull
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
