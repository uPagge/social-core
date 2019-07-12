package org.sadtech.social.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sadtech.social.core.domain.content.attachment.GeoCoordinate;
import org.sadtech.social.core.domain.keyboard.KeyBoard;
import org.sadtech.social.core.utils.Description;

/**
 * Контейнер, которые содержит данные, которые будут отправлены пользователю как ответ на его запрос.
 *
 * @author upagge [08/07/2019]
 */
@EqualsAndHashCode
@ToString
@Getter
public class BoxAnswer {

    @Description("Обычное текстовое сообщение")
    private String message;

    @Description("Клавиатура - меню")
    private KeyBoard keyboard;

    @Description("Географические координаты")
    private GeoCoordinate coordinates;

    @Description("Идентификатор стикера")
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

    public void setMessage(String message) {
        this.message = message;
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

}
