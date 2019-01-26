package org.sadtech.vkbot.core.keyboard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard {

    private List<LineKeyBoard> lineKeyBoards = new ArrayList<>();
    private boolean oneTime;

    public KeyBoard() {

    }

    public KeyBoard(List<LineKeyBoard> lineKeyBoards, boolean oneTime) {
        this.lineKeyBoards = lineKeyBoards;
        this.oneTime = oneTime;
    }

    public void setOneTime(boolean oneTime) {
        this.oneTime = oneTime;
    }

    public JSONObject getKeyboard() {
        JSONObject keyboard = new JSONObject();
        keyboard.put("one_time", oneTime);

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

        public Builder setOneTime(boolean oneTime) {
            KeyBoard.this.oneTime = oneTime;
            return this;
        }

        public KeyBoard build() {
            return KeyBoard.this;
        }

    }
}
