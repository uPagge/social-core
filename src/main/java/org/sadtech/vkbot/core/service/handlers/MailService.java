package org.sadtech.vkbot.core.service.handlers;

import com.vk.api.sdk.objects.messages.Message;
import org.sadtech.vkbot.core.entity.Mail;

public interface MailService extends SortEventService<Mail> {

    void add(Mail mail);

    void add(Message message);

}
