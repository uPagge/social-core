package org.sadtech.social.core.repository.jpa.impl;

import org.sadtech.social.core.domain.content.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO: Добавить описание интерфейса.
 *
 * @author upagge [27/07/2019]
 */
public interface MailRepository extends JpaRepository<Mail, Integer> {

    List<Mail> findByCreateDateBetween(LocalDateTime from, LocalDateTime to);

}
