package org.sadtech.social.core.domain.content;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.sadtech.social.core.utils.Description;

/**
 * Абстрактная сущность для сообщений от пользователей с привязкой к какому-то контенту (картинка, видео).
 *
 * @author upagge [08/07/2019]
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class Comment extends Message {

    @Description("Идентификатор контента, к которому ставлено сообщение")
    private Long contentId;

}
