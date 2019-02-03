package org.sadtech.vkbot.core.sender;

import org.sadtech.vkbot.core.entity.MailSend;

import java.util.List;

public interface MailSandler {

    void send(MailSend mailSend, Integer idUser);

    void send(MailSend mailSend, Integer idUser, List<String> insertWords);

}
