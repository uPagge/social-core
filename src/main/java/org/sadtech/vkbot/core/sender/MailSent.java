package org.sadtech.vkbot.core.sender;

import org.sadtech.vkbot.core.entity.MailSend;

import java.util.List;

public interface MailSent {

    void send(MailSend mailSend, Integer peerId, Integer userId);

    void send(MailSend mailSend, Integer peerId, Integer userId, List<String> insertWords);

}
