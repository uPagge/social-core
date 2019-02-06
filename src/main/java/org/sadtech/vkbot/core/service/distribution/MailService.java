package org.sadtech.vkbot.core.service.distribution;

import com.vk.api.sdk.objects.messages.Message;
import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.service.distribution.impl.EventService;

public interface MailService extends EventService<Mail>, SortEventService<Mail> {

    void add(Message message);

}
