package org.sadtech.bot.core.domain;

import java.util.Objects;

public class BoxAnswer {

    private String message;
    private String keyboard;
    private Float lat;
    private Float aLong;
    private Integer stickerId;

    public BoxAnswer() {

    }

    public BoxAnswer(BoxAnswer target) {
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

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
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
