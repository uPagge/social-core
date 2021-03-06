package org.sadtech.social.core.domain.content.attachment;

import lombok.EqualsAndHashCode;
import org.sadtech.social.core.utils.Description;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Абстрактная сущность, для всех вложений к сообщениям от пользователей.
 *
 * @author upagge [08/07/2019]
 */
@Entity
@EqualsAndHashCode
public abstract class Attachment {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    @Description("Тип сущности")
    protected AttachmentType type;

    public AttachmentType getType() {
        return type;
    }

}
