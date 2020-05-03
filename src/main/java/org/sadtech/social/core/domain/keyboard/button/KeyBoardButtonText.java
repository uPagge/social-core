package org.sadtech.social.core.domain.keyboard.button;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sadtech.social.core.domain.keyboard.ButtonColor;
import org.sadtech.social.core.domain.keyboard.ButtonType;
import org.sadtech.social.core.domain.keyboard.KeyBoardButton;
import org.sadtech.social.core.utils.Description;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class KeyBoardButtonText extends KeyBoardButton {

    @Description("Надпись на кнопке")
    private String label;

    @Description("Цвет кнопки")
    private ButtonColor color;

    @Builder
    private KeyBoardButtonText(String payload, String label, ButtonColor color) {
        super(payload, ButtonType.TEXT);
        this.label = label;
        this.color = (color != null) ? color : ButtonColor.DEFAULT;
    }

    public static KeyBoardButtonText of(String label) {
        return KeyBoardButtonText.builder().label(label).build();
    }

}
