package org.sadtech.vkbot.core.distribution.impl;

import com.vk.api.sdk.objects.messages.Message;
import org.sadtech.vkbot.core.distribution.EventDistributable;
import org.sadtech.vkbot.core.distribution.EventSubscribe;
import org.sadtech.vkbot.core.service.distribution.MailService;

public class MailChatSubscriber implements EventSubscribe<Message> {

    private MailService mailService;

    public MailChatSubscriber(EventDistributable eventDistributable, MailService mailService) {
        this.mailService = mailService;
        eventDistributable.registerSubscriber("chat", this);
    }

    public MailChatSubscriber(EventDistributable eventDistributable) {
        eventDistributable.registerSubscriber("chat", this);
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void update(Message message) {
        mailService.add(message);
    }

}
