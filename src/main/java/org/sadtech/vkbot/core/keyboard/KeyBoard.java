package org.sadtech.vkbot.core.keyboard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard {

    private List<LineKeyBoard> lineKeyBoards = new ArrayList<>();

    public KeyBoard() {

    }

    public KeyBoard(List<LineKeyBoard> lineKeyBoards) {
        this.lineKeyBoards = lineKeyBoards;
    }

    public JSONObject getKeyboard(Boolean one_time) {
        JSONObject keyboard = new JSONObject();
        keyboard.put("one_time", one_time);

        JSONArray menuLine = new JSONArray();
        for (LineKeyBoard lineKeyboard : lineKeyBoards) {
            menuLine.put(lineKeyboard.getLine());
        }

        keyboard.put("buttons", menuLine);
        return keyboard;
    }

    public void addLine(LineKeyBoard lineKeyBoard) {
        lineKeyBoards.add(lineKeyBoard);
    }

    public static Builder builder() {
        return new KeyBoard().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setLineKeyBoard(LineKeyBoard lineKeyBoard) {
            KeyBoard.this.lineKeyBoards.add(lineKeyBoard);
            return this;
        }

        public KeyBoard build() {
            return KeyBoard.this;
        }

    }
}
