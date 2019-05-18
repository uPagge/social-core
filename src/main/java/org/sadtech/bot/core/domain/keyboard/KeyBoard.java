package org.sadtech.bot.core.domain.keyboard;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard {

    private List<KeyBoardLine> keyBoardLines = new ArrayList<>();
    private boolean oneTime = true;

    private KeyBoard() {

    }

    public List<KeyBoardLine> getKeyBoardLines() {
        return keyBoardLines;
    }

    public boolean isOneTime() {
        return oneTime;
    }

    public static Builder builder() {
        return new KeyBoard().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder lineKeyBoard(KeyBoardLine keyBoardLine) {
            KeyBoard.this.keyBoardLines.add(keyBoardLine);
            return this;
        }

        public Builder oneTime(boolean oneTime) {
            KeyBoard.this.oneTime = oneTime;
            return this;
        }

        public KeyBoard build() {
            return KeyBoard.this;
        }

    }
}
