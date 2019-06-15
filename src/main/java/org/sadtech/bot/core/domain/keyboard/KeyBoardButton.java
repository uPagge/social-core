package org.sadtech.bot.core.domain.keyboard;

import java.util.Objects;

public abstract class KeyBoardButton {

    protected String payload;
    protected ButtonType type = ButtonType.TEXT;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBoardButton)) return false;
        KeyBoardButton that = (KeyBoardButton) o;
        return Objects.equals(payload, that.payload) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, type);
    }
}
