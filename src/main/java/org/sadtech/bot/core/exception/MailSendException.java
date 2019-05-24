package org.sadtech.bot.core.exception;

public class MailSendException extends AppBotException {

    public MailSendException() {
        super(1, "Ошибка отправки сообщения");
    }

}
