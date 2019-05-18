package org.sadtech.bot.core.repository.impl;

import org.sadtech.bot.core.domain.Mail;
import org.sadtech.bot.core.repository.EventRepository;
import org.sadtech.bot.core.repository.MailRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MailRepositoryList implements EventRepository<Mail>, MailRepository {

    private final List<Mail> mails = new ArrayList<>();

    @Override
    public void add(Mail mail) {
        mails.add(mail);
    }

    @Override
    public void cleanAll() {
        mails.clear();
    }

    @Override
    public Queue<Mail> getEventQueue() {
        return new ConcurrentLinkedQueue<>(mails);
    }

    public List<Mail> getMailByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        ArrayList<Mail> rezultMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!(mails.get(i).getDate().isBefore(timeFrom) || mails.get(i).getDate().isAfter(timeTo)) && mails.get(i).getDate().equals(timeFrom)) {
                rezultMails.add(this.mails.get(i));
            } else if (mails.get(i).getDate().isBefore(timeFrom)) {
                break;
            }
        }
        return rezultMails;
    }


}
