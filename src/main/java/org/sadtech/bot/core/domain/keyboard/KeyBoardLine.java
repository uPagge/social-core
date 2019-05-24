package org.sadtech.bot.core.domain.keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeyBoardLine {

    private List<KeyBoardButton> keyBoardButtons = new ArrayList<>();

    private KeyBoardLine() {

    }

    public List<KeyBoardButton> getKeyBoardButtons() {
        return keyBoardButtons;
    }

    public static Builder builder() {
        return new KeyBoardLine().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder buttonKeyBoard(KeyBoardButton keyBoardButton) {
            KeyBoardLine.this.keyBoardButtons.add(keyBoardButton);
            return this;
        }

        public KeyBoardLine build() {
            return KeyBoardLine.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBoardLine)) return false;
        KeyBoardLine that = (KeyBoardLine) o;
        return Objects.equals(keyBoardButtons, that.keyBoardButtons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyBoardButtons);
    }

    @Override
    public String toString() {
        return "KeyBoardLine{" +
                "keyBoardButtons=" + keyBoardButtons +
                '}';
    }
}
