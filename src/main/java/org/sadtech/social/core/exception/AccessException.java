package org.sadtech.social.core.exception;

/**
 * Ошибка доступа к чему-либо.
 *
 * @author upagge [08/07/2019]
 */
public class AccessException extends AppBotException {
    public AccessException(Integer code, String message) {
        super(code, message);
    }
}