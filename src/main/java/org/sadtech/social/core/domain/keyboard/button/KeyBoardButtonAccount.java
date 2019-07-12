package org.sadtech.social.core.domain.keyboard.button;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sadtech.social.core.domain.keyboard.ButtonType;
import org.sadtech.social.core.domain.keyboard.KeyBoardButton;
import org.sadtech.social.core.utils.Description;

/**
 * Кнопка клавиатуры для оплаты счета.
 *
 * @author upagge [08/07/2019]
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class KeyBoardButtonAccount extends KeyBoardButton {

    @Description("Сумма к оплате")
    private Integer amount;

    @Description("Идентификатор счета")
    private Integer accountId;

    @Description("Описание")
    private String description;

    @Builder
    private KeyBoardButtonAccount(String payload, Integer amount, Integer accountId, String description) {
        super(payload, ButtonType.ACCOUNT);
        this.amount = amount;
        this.accountId = accountId;
        this.description = description;
    }
}
