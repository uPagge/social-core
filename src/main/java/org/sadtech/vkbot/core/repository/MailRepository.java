package org.sadtech.vkbot.core.repository;

import org.sadtech.vkbot.core.entity.Mail;

import java.util.List;

public interface MailRepository {

    void add(Mail message);

    List<Mail> getMailByTime(Integer timeFrom, Integer timeTo);

}
