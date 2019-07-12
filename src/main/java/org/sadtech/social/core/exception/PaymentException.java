package org.sadtech.social.core.exception;

/**
 * Ошибка оплаты.
 *
 * @author upagge [08/07/2019]
 */
public class PaymentException extends AppBotException {

    public PaymentException(Integer code, String message) {
        super(code, message);
    }

}
