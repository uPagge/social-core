package org.sadtech.bot.core.domain.keyboard;

import java.util.Objects;

public class KeyBoardButton {

    private String payload;
    private String label;
    private ButtonColor color = ButtonColor.DEFAULT;

    private KeyBoardButton() {

    }

    public String getPayload() {
        return payload;
    }

    public String getLabel() {
        return label;
    }

    public ButtonColor getColor() {
        return color;
    }

    public static Builder builder() {
        return new KeyBoardButton().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder color(ButtonColor color) {
            KeyBoardButton.this.color = color;
            return this;
        }

        public Builder label(String label) {
            KeyBoardButton.this.label = label;
            return this;
        }

        public Builder payload(String payload) {
            KeyBoardButton.this.payload = payload;
            return this;
        }

        public KeyBoardButton build() {
            return KeyBoardButton.this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBoardButton)) return false;
        KeyBoardButton button = (KeyBoardButton) o;
        return Objects.equals(payload, button.payload) &&
                Objects.equals(label, button.label) &&
                color == button.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, label, color);
    }

    @Override
    public String toString() {
        return "KeyBoardButton{" +
                "payload='" + payload + '\'' +
                ", label='" + label + '\'' +
                ", color=" + color +
                '}';
    }
}
