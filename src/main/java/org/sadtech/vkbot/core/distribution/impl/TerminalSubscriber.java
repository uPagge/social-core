package org.sadtech.vkbot.core.distribution.impl;

import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.distribution.EventSubscribe;
import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.service.handlers.MailService;

public class TerminalSubscriber implements EventSubscribe<Mail> {

    public static final Logger log = Logger.getLogger(TerminalSubscriber.class);

    private MailService mailService;

    public TerminalSubscriber(MailSubscriber mailSubscriber, MailService mailService) {
        this.mailService = mailService;
        mailSubscriber.registerSubscriber("terminal", this);
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void update(Mail object) {
        log.info("Сообщение отправленно на добавление в репозиторий команд");
        mailService.add(object);
    }

}
