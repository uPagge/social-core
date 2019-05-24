package org.sadtech.bot.core.exception;

public class PaymentException extends AppBotException {

    public PaymentException(String message, Integer code) {
        super(message, code);
    }

    public PaymentException(Integer code) {
        super(code);
    }

}
