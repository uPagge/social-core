package org.sadtech.vkbot.core.keyboard;

import org.json.JSONObject;

public class ButtonKeyBoard {

    private String type = "text";
    private String payload;
    private String label;
    private ColorButton color = ColorButton.PRIMARY;

    public ButtonKeyBoard() {

    }

    public ButtonKeyBoard(String type, String payload, String label, ColorButton color) {
        this.type = type;
        this.payload = payload;
        this.label = label;
        this.color = color;
    }

    public JSONObject getButton() {
        JSONObject newButton = new JSONObject();
        newButton.put("color", color.toString().toLowerCase());
        newButton.put("action", generateAction());
        return newButton;
    }

    private JSONObject generateAction() {
        JSONObject action = new JSONObject();
        action.put("type", type);
        action.put("payload", payload);
        action.put("label", label);
        return action;
    }

    public static Builder builder() {
        return new ButtonKeyBoard().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setColor(ColorButton color) {
            ButtonKeyBoard.this.color = color;
            return this;
        }

        public Builder setLabel(String label) {
            ButtonKeyBoard.this.label = label;
            return this;
        }

        public Builder setPayload(String payload) {
            ButtonKeyBoard.this.payload = payload;
            return this;
        }

        public Builder setType(String type) {
            ButtonKeyBoard.this.type = type;
            return this;
        }

        public ButtonKeyBoard build() {
            return ButtonKeyBoard.this;
        }

    }

}
