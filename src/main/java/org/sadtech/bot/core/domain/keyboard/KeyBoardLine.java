package org.sadtech.bot.core.domain.keyboard;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardLine {

    private List<KeyBoardButton> keyBoardButtons = new ArrayList<>();

    public KeyBoardLine() {

    }

    public KeyBoardLine(List<KeyBoardButton> keyBoardButtons) {
        this.keyBoardButtons = keyBoardButtons;
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

        public Builder setButtonKeyBoard(KeyBoardButton keyBoardButton) {
            KeyBoardLine.this.keyBoardButtons.add(keyBoardButton);
            return this;
        }

        public KeyBoardLine build() {
            return KeyBoardLine.this;
        }
    }
}
