package org.sadtech.vkbot.core.service.handlers;

import org.sadtech.vkbot.core.entity.Mail;

public interface MailService extends SortEventService<Mail> {

    void add(Mail mail);

}
