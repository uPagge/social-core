package org.sadtech.bot.core.domain;

import org.sadtech.bot.core.domain.keyboard.KeyBoard;

import java.util.Objects;

public class BoxAnswer {

    private String message;
    private KeyBoard keyboard;
    private Float lat;
    private Float aLong;
    private Integer stickerId;

    public BoxAnswer() {

    }

    private BoxAnswer(BoxAnswer target) {
        if (target != null) {
            this.message = target.getMessage();
            this.keyboard = target.getKeyboard();
            this.lat = target.getLat();
            this.aLong = target.getaLong();
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

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getaLong() {
        return aLong;
    }

    public void setaLong(Float aLong) {
        this.aLong = aLong;
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

        public Builder lat(Float lat) {
            BoxAnswer.this.lat = lat;
            return this;
        }

        public Builder aLong(Float aLong) {
            BoxAnswer.this.aLong = aLong;
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
        if (o == null || getClass() != o.getClass()) return false;
        BoxAnswer boxAnswer = (BoxAnswer) o;
        return Objects.equals(message, boxAnswer.message) &&
                Objects.equals(keyboard, boxAnswer.keyboard) &&
                Objects.equals(lat, boxAnswer.lat) &&
                Objects.equals(aLong, boxAnswer.aLong) &&
                Objects.equals(stickerId, boxAnswer.stickerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, keyboard, lat, aLong, stickerId);
    }


}
