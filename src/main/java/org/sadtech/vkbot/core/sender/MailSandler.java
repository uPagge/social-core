package org.sadtech.vkbot.core.sender;

import org.sadtech.vkbot.core.entity.MailSend;

import java.util.List;

public interface MailSandler {

    void send(MailSend mailSend, Integer peerId);

    void send(MailSend mailSend, Integer peerId, Integer userId);

    void send(MailSend mailSend, Integer peerId, List<String> insertWords);

    void send(MailSend mailSend, Integer peerId, Integer userId, List<String> insertWords);

}
