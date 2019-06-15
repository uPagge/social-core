package org.sadtech.bot.core.utils;

import org.sadtech.bot.core.domain.keyboard.ButtonColor;
import org.sadtech.bot.core.domain.keyboard.KeyBoard;
import org.sadtech.bot.core.domain.keyboard.KeyBoardButton;
import org.sadtech.bot.core.domain.keyboard.KeyBoardLine;
import org.sadtech.bot.core.domain.keyboard.button.KeyBoardButtonText;

import java.util.List;

public class KeyBoards {

    private KeyBoards() {
        throw new IllegalStateException();
    }

    public static KeyBoard keyBoardYesNo() {
        KeyBoardButton yesButton = KeyBoardButtonText.builder().color(ButtonColor.POSITIVE).label("Да").payload("{\"button\": \"yes\"}").build();
        KeyBoardButton noButton = KeyBoardButtonText.builder().color(ButtonColor.NEGATIVE).label("Нет").payload("{\"button\": \"no\"}").build();
        KeyBoardLine keyBoardLine = KeyBoardLine.builder().buttonKeyBoard(yesButton).buttonKeyBoard(noButton).build();
        return KeyBoard.builder().lineKeyBoard(keyBoardLine).oneTime(true).build();
    }

    public static KeyBoard verticalMenuString(List<String> labelButtons) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        for (String labelButton : labelButtons) {
            KeyBoardButton keyBoardButton = KeyBoardButtonText.builder().label(labelButton).payload("{\"button\": \"" + labelButton + "\"}").build();
            keyBoard.lineKeyBoard(KeyBoardLine.builder().buttonKeyBoard(keyBoardButton).build());
        }
        return keyBoard.build();
    }

    public static KeyBoard verticalMenuString(String... labelButton) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        for (String label : labelButton) {
            KeyBoardButton keyBoardButton = KeyBoardButtonText.builder().label(label).payload("{\"button\": \"" + label + "\"}").build();
            keyBoard.lineKeyBoard(KeyBoardLine.builder().buttonKeyBoard(keyBoardButton).build());
        }
        return keyBoard.build();
    }

    public static KeyBoard verticalDuoMenuString(String... labelButton) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        boolean flag = true;
        KeyBoardLine.Builder keyBoardLine = KeyBoardLine.builder();
        for (String label : labelButton) {
            if (flag) {
                keyBoardLine.buttonKeyBoard(KeyBoardButtonText.builder().label(label).build());
                flag = false;
            } else {
                keyBoardLine.buttonKeyBoard(KeyBoardButtonText.builder().label(label).build());
                keyBoard.lineKeyBoard(keyBoardLine.build());
                keyBoardLine = KeyBoardLine.builder();
                flag = true;
            }
        }
        return keyBoard.build();
    }

    public static KeyBoard verticalMenuButton(List<KeyBoardButton> keyBoardButtons) {
        KeyBoard.Builder keyBoard = KeyBoard.builder().oneTime(true);
        for (KeyBoardButton keyBoardButton : keyBoardButtons) {
            keyBoard.lineKeyBoard(KeyBoardLine.builder().buttonKeyBoard(keyBoardButton).build());
        }
        return keyBoard.build();
    }

    public static KeyBoard singelton(KeyBoardButton keyBoardButton) {
        KeyBoardLine line = KeyBoardLine.builder().buttonKeyBoard(keyBoardButton).build();
        return KeyBoard.builder().lineKeyBoard(line).build();
    }
}
