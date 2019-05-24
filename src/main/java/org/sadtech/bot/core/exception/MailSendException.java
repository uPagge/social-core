package org.sadtech.bot.core.exception;

public class MailSendException extends AppBotException {

    public final static Integer CODE = 1;

    public MailSendException() {
        super(CODE);
    }
}
