package org.sadtech.bot.core.domain;

import org.sadtech.bot.core.domain.content.GeoCoordinate;
import org.sadtech.bot.core.domain.keyboard.KeyBoard;

import java.util.Objects;

public class BoxAnswer {

    private String message;
    private KeyBoard keyboard;
    private GeoCoordinate coordinates;
    private Integer stickerId;

    private BoxAnswer() {

    }

    private BoxAnswer(BoxAnswer target) {
        if (target != null) {
            this.message = target.getMessage();
            this.keyboard = target.getKeyboard();
            this.coordinates = target.getCoordinates();
            this.stickerId = target.getStickerId();
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public KeyBoard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(KeyBoard keyboard) {
        this.keyboard = keyboard;
    }

    public GeoCoordinate getCoordinates() {
        return coordinates;
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public void setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
    }

    public BoxAnswer prototype() {
        return new BoxAnswer(this);
    }

    public static Builder builder() {
        return new BoxAnswer().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder message(String message) {
            BoxAnswer.this.message = message;
            return this;
        }

        public Builder keyBoard(KeyBoard keyBoard) {
            BoxAnswer.this.keyboard = keyBoard;
            return this;
        }

        public Builder coordinate(Float lat, Float aLong) {
            BoxAnswer.this.coordinates = new GeoCoordinate(lat, aLong);
            return this;
        }

        public Builder steckerId(Integer stickerId) {
            BoxAnswer.this.stickerId = stickerId;
            return this;
        }

        public BoxAnswer build() {
            return BoxAnswer.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoxAnswer)) return false;
        BoxAnswer boxAnswer = (BoxAnswer) o;
        return Objects.equals(message, boxAnswer.message) &&
                Objects.equals(keyboard, boxAnswer.keyboard) &&
                Objects.equals(coordinates, boxAnswer.coordinates) &&
                Objects.equals(stickerId, boxAnswer.stickerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, keyboard, coordinates, stickerId);
    }

    @Override
    public String toString() {
        return "BoxAnswer{" +
                "message='" + message + '\'' +
                ", keyboard=" + keyboard +
                ", coordinates=" + coordinates +
                ", stickerId=" + stickerId +
                '}';
    }
}
