package org.sadtech.social.core.repository.jpa;

import org.sadtech.social.core.domain.content.Mail;
import org.sadtech.social.core.repository.ContentRepository;
import org.sadtech.social.core.repository.jpa.impl.MailRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO: Добавить описание класса.
 *
 * @author upagge [25/07/2019]
 */
public class MailRepositoryJpa implements ContentRepository<Mail> {

    private final MailRepository mailRepository;

    public MailRepositoryJpa(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public Integer add(Mail content) {
        return mailRepository.saveAndFlush(content).getId();
    }

    @Override
    public List<Mail> findByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        return mailRepository.findByCreateDateBetween(timeFrom, timeTo);
    }
}
