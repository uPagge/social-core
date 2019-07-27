package org.sadtech.social.core.repository.impl.local;

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
public class MailRepositoryList implements ContentRepository<Mail> {

    private final List<Mail> mails = new ArrayList<>();

    @Override
    public Integer add(Mail mail) {
        mails.add(mail);
        return mails.size() - 1;
    }


    @Override
    public List<Mail> findByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        ArrayList<Mail> rezultMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!(mails.get(i).getCreateDate().isBefore(timeFrom) || mails.get(i).getCreateDate().isAfter(timeTo)) && mails.get(i).getCreateDate().equals(timeFrom)) {
                rezultMails.add(this.mails.get(i));
            } else if (mails.get(i).getCreateDate().isBefore(timeFrom)) {
                break;
            }
        }
        return rezultMails;
    }


}
