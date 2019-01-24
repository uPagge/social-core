package org.sadtech.vkbot.core.entity.unit;

import org.sadtech.vkbot.core.keyboard.KeyBoard;

public class TextAndKeyBoardAnswer extends TextAnswer {

    KeyBoard keyBoard;

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }
}
