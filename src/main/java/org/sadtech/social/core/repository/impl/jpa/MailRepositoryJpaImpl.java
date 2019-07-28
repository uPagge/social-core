package org.sadtech.social.core.repository.impl.jpa;

import lombok.RequiredArgsConstructor;
import org.sadtech.social.core.domain.content.Mail;
import org.sadtech.social.core.repository.ContentRepository;
import org.sadtech.social.core.repository.jpa.MailRepositoryJpa;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Реализация репозитория.
 *
 * @author upagge [25/07/2019]
 */
@RequiredArgsConstructor
public class MailRepositoryJpaImpl implements ContentRepository<Mail> {

    private final MailRepositoryJpa mailRepositoryJpa;

    @Override
    public Integer add(Mail content) {
        return mailRepositoryJpa.saveAndFlush(content).getId();
    }

    @Override
    public List<Mail> betweenByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        return mailRepositoryJpa.findByCreateDateBetween(timeFrom, timeTo);
    }
}
