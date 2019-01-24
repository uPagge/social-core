package org.sadtech.vkbot.core.keyboard;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class LineKeyBoard {

    private List<ButtonKeyBoard> buttonKeyBoards = new ArrayList<>();

    public LineKeyBoard() {

    }

    public LineKeyBoard(List<ButtonKeyBoard> buttonKeyBoards) {
        this.buttonKeyBoards = buttonKeyBoards;
    }

    public JSONArray getLine() {
        JSONArray line = new JSONArray();
        for (ButtonKeyBoard buttonKeyBoard : buttonKeyBoards) {
            line.put(buttonKeyBoard.getButton());
        }
        return line;
    }

    public static Builder builder() {
        return new LineKeyBoard().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setButtonKeyBoard(ButtonKeyBoard buttonKeyBoard) {
            LineKeyBoard.this.buttonKeyBoards.add(buttonKeyBoard);
            return this;
        }

        public LineKeyBoard build() {
            return LineKeyBoard.this;
        }
    }
}
