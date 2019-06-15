package org.sadtech.bot.core.domain.keyboard.button;

import org.sadtech.bot.core.domain.keyboard.ButtonColor;
import org.sadtech.bot.core.domain.keyboard.ButtonType;
import org.sadtech.bot.core.domain.keyboard.KeyBoardButton;

import java.util.Objects;

public class KeyBoardButtonText extends KeyBoardButton {

    private String label;
    private ButtonColor color = ButtonColor.DEFAULT;

    public KeyBoardButtonText() {
        type = ButtonType.TEXT;
    }

    public ButtonColor getColor() {
        return color;
    }

    public String getLabel() {
        return label;
    }

    public static Builder builder() {
        return new KeyBoardButtonText().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder label(String label) {
            KeyBoardButtonText.this.label = label;
            return this;
        }

        public Builder color(ButtonColor color) {
            KeyBoardButtonText.this.color = color;
            return this;
        }

        public Builder payload(String payload) {
            KeyBoardButtonText.this.payload = payload;
            return this;
        }

        public KeyBoardButtonText build() {
            return KeyBoardButtonText.this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBoardButtonText)) return false;
        if (!super.equals(o)) return false;
        KeyBoardButtonText that = (KeyBoardButtonText) o;
        return Objects.equals(label, that.label) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label, color);
    }

    @Override
    public String toString() {
        return "KeyBoardButtonText{" +
                "label='" + label + '\'' +
                ", color=" + color +
                '}';
    }
}
