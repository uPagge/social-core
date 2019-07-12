package org.sadtech.social.core.domain.content.attachment;

import lombok.EqualsAndHashCode;
import org.sadtech.social.core.utils.Description;

/**
 * Абстрактная сущность, для всех вложений к сообщениям от пользователей.
 *
 * @author upagge [08/07/2019]
 */
@EqualsAndHashCode
public abstract class Attachment {

    @Description("Тип сущности")
    protected AttachmentType type;

    public AttachmentType getType() {
        return type;
    }

}
