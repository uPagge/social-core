package org.sadtech.social.core.repository.impl.local;

import lombok.extern.slf4j.Slf4j;
import org.sadtech.social.core.domain.content.Mail;
import org.sadtech.social.core.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Локальная реализация репозитория на основе {@link ArrayList} для взаимодействия с сущностью {@link Mail}.
 *
 * @author upagge [27/07/2019]
 */
@Slf4j
public class MailRepositoryList implements ContentRepository<Mail> {

    private final List<Mail> mails = new ArrayList<>();
    private Long count = 0L;

    @Override
    public Mail add(Mail mail) {
        mail.setId(count++);
        mails.add(mail);
        return mail;
    }

    @Override
    public List<Mail> betweenByCreateDateTime(LocalDateTime from, LocalDateTime to) {
        ArrayList<Mail> rezultMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            Mail mail = mails.get(i);
            if (isTimePeriod(from, to, mail.getAddDate())) {
                rezultMails.add(mail);
            } else if (mail.getCreateDate().isBefore(from)) {
                break;
            }
        }
        return rezultMails;
    }

    @Override
    public List<Mail> betweenByAddDateTime(LocalDateTime from, LocalDateTime to) {
        ArrayList<Mail> rezultMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            Mail mail = mails.get(i);
            LocalDateTime addDate = mail.getAddDate();
            if (isTimePeriod(from, to, addDate)) {
                rezultMails.add(mail);
            } else if (addDate.isBefore(from)) {
                break;
            }
        }
        return rezultMails;
    }

    private boolean isTimePeriod(LocalDateTime from, LocalDateTime to, LocalDateTime dateTime) {
        return from.isBefore(dateTime) && to.isAfter(dateTime);
    }


}
