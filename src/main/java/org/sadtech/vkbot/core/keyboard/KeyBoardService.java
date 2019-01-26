package org.sadtech.vkbot.core.keyboard;

import java.util.List;

public class KeyBoardService {

    private KeyBoard keyBoardYesNo = generateKeyBoardYesNo();

    private KeyBoard generateKeyBoardYesNo() {
        ButtonKeyBoard yesButton = ButtonKeyBoard.builder().setColor(ColorButton.POSITIVE).setLabel("Да").setPayload("{\"button\": \"yes\"}").build();
        ButtonKeyBoard noButton = ButtonKeyBoard.builder().setColor(ColorButton.NEGATIVE).setLabel("Нет").setPayload("{\"button\": \"no\"}").build();
        LineKeyBoard lineKeyBoard = LineKeyBoard.builder().setButtonKeyBoard(yesButton).setButtonKeyBoard(noButton).build();
        KeyBoard keyBoard = KeyBoard.builder().setLineKeyBoard(lineKeyBoard).build();
        return keyBoard;
    }

    public static KeyBoard verticalMenu(List<String> labelButtons) {
        KeyBoard keyBoard = new KeyBoard();
        for (String labelButton : labelButtons) {
            ButtonKeyBoard buttonKeyBoard = ButtonKeyBoard.builder().setLabel(labelButton).setType("text").setPayload("{\"button\": \"" + labelButton + "\"}").build();
            keyBoard.addLine(LineKeyBoard.builder().setButtonKeyBoard(buttonKeyBoard).build());
        }
        return keyBoard;
    }

    public KeyBoard getKeyBoardYesNo() {
        return keyBoardYesNo;
    }
}
