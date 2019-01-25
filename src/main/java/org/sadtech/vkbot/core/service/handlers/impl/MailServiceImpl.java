package org.sadtech.vkbot.core.service.handlers.impl;

import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.repository.MailRepository;
import org.sadtech.vkbot.core.repository.impl.MailRepositoryList;
import org.sadtech.vkbot.core.service.handlers.MailService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MailServiceImpl implements MailService {

    public static final Logger log = Logger.getLogger(MailServiceImpl.class);

    private MailRepository messageRepository;

    public MailServiceImpl() {
        this.messageRepository = new MailRepositoryList();
    }

    public MailServiceImpl(MailRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void add(Mail mail) {
        messageRepository.add(mail);
    }

    @Override
    public List<Mail> getFirstMailByTime(Integer timeFrom, Integer timeTo) {
        log.info("Запрошены сообщения от " + timeFrom + " до " + timeTo);
        List<Mail> mails = messageRepository.getMailByTime(timeFrom, timeTo);
        Set<Person> people = new HashSet<>();
        List<Mail> returnMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!people.contains(mails.get(i).getPerson())) {
                returnMails.add(mails.get(i));
                people.add(mails.get(i).getPerson());
            }
        }
        return returnMails;
    }

    @Override
    public List<Mail> getLastMailByTime(Integer timeFrom, Integer timeTo) {
        List<Mail> mails = messageRepository.getMailByTime(timeFrom, timeTo);
        Set<Person> people = new HashSet<>();
        List<Mail> returnMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (!people.contains(mail.getPerson())) {
                returnMails.add(mail);
                people.add(mail.getPerson());
            }
        }
        return returnMails;
    }

    @Override
    public List<Mail> getEvent(Integer timeFrom, Integer timeTo) {
        log.info("Запрос на получение сообщений в интервале от " + timeFrom + " до " + timeTo);
        return messageRepository.getMailByTime(timeFrom, timeTo);
    }
}
