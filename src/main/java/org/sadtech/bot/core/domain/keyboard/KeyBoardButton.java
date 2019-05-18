package org.sadtech.bot.core.domain.keyboard;

import com.google.gson.JsonObject;

import java.util.Objects;

public class KeyBoardButton {

    private String payload;
    private String label;
    private ButtonColor color = ButtonColor.DEFAULT;

    public KeyBoardButton() {

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

    private JsonObject generateAction() {
        JsonObject action = new JsonObject();
        action.addProperty("payload", payload);
        action.addProperty("label", label);
        return action;
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
        KeyBoardButton that = (KeyBoardButton) o;
        return Objects.equals(payload, that.payload) &&
                Objects.equals(label, that.label) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, label, color);
    }
}
