package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.keyboard.ButtonColor;
import org.sadtech.bot.core.domain.keyboard.KeyBoard;
import org.sadtech.bot.core.domain.keyboard.KeyBoardButton;
import org.sadtech.bot.core.domain.keyboard.KeyBoardLine;

import java.util.List;

public class KeyBoards {

    private KeyBoards() {
        throw new IllegalStateException();
    }

    public static KeyBoard keyBoardYesNo() {
        KeyBoardButton yesButton = KeyBoardButton.builder().color(ButtonColor.POSITIVE).label("Да").payload("{\"button\": \"yes\"}").build();
        KeyBoardButton noButton = KeyBoardButton.builder().color(ButtonColor.NEGATIVE).label("Нет").payload("{\"button\": \"no\"}").build();
        KeyBoardLine keyBoardLine = KeyBoardLine.builder().setButtonKeyBoard(yesButton).setButtonKeyBoard(noButton).build();
        return KeyBoard.builder().lineKeyBoard(keyBoardLine).oneTime(true).build();
    }

    public static KeyBoard verticalMenuString(List<String> labelButtons) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        for (String labelButton : labelButtons) {
            KeyBoardButton keyBoardButton = KeyBoardButton.builder().label(labelButton).payload("{\"button\": \"" + labelButton + "\"}").build();
            keyBoard.lineKeyBoard(KeyBoardLine.builder().setButtonKeyBoard(keyBoardButton).build());
        }
        return keyBoard.build();
    }

    public static KeyBoard verticalMenuButton(List<KeyBoardButton> keyBoardButtons) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        for (KeyBoardButton keyBoardButton : keyBoardButtons) {
            keyBoard.lineKeyBoard(KeyBoardLine.builder().setButtonKeyBoard(keyBoardButton).build());
        }
        return keyBoard.build();
    }
}
