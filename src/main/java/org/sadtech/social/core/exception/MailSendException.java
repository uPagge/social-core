package org.sadtech.social.core.exception;

/**
 * Ошибки при отправке сообщений.
 *
 * @author upagge [08/07/2019]
 */
public class MailSendException extends AppBotException {

    public MailSendException() {
        super("Ошибка отправки сообщения");
    }

}
