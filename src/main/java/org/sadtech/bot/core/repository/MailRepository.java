package org.sadtech.bot.core.repository;

import org.sadtech.bot.core.domain.Mail;

import java.util.List;

public interface MailRepository {

    void add(Mail mail);

    List<Mail> getMailByTime(Integer timeFrom, Integer timeTo);

}
