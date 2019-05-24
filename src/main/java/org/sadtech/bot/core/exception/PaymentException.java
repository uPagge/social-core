package org.sadtech.bot.core.exception;

public class PaymentException extends AppBotException {

    public PaymentException(Integer code, String message) {
        super(code, message);
    }

}
