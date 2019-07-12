package org.sadtech.social.core.service.impl;

import org.sadtech.social.core.domain.content.Mail;
import org.sadtech.social.core.repository.ContentRepository;
import org.sadtech.social.core.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    private final ContentRepository<Mail> mailRepository;

    public MailServiceImpl(ContentRepository<Mail> mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public void add(Mail mail) {
        mailRepository.add(mail);
        log.info("Сообщение добавлено в репозиторий | {}", mail);
    }

    @Override
    public List<Mail> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        log.info("Запрошены последние сообщения {} - {} ", timeFrom, timeTo);
        List<Mail> mails = mailRepository.findByTime(timeFrom, timeTo);
        Set<Integer> people = new HashSet<>();
        List<Mail> returnMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!people.contains(mails.get(i).getPersonId())) {
                returnMails.add(mails.get(i));
                people.add(mails.get(i).getPersonId());
            }
        }
        return returnMails;
    }

    @Override
    public List<Mail> getByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        log.info("Запрошены все сообщения {} - {} ", timeFrom, timeTo);
        return mailRepository.findByTime(timeFrom, timeTo);
    }

}
