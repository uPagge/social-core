package org.sadtech.social.core.domain.keyboard;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sadtech.social.core.utils.Description;

/**
 * Абстрактная сущность кнопки для клавиатуры.
 *
 * @author upagge [08/07/2019]
 */
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class KeyBoardButton {

    @Description("Скрытое сообщение, отправляемое по нажатию")
    protected String payload;

    @Description("Тип кнопки")
    protected ButtonType type;

}
