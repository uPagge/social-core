package org.sadtech.bot.core.repository.impl;

import org.sadtech.bot.core.domain.Mail;
import org.sadtech.bot.core.repository.EventRepository;
import org.sadtech.bot.core.repository.MailRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MailRepositoryList implements EventRepository<Mail>, MailRepository {

    private final List<Mail> messages = new ArrayList<>();

    @Override
    public void add(Mail mail) {
        messages.add(mail);
    }

    @Override
    public void cleanAll() {
        messages.clear();
    }

    @Override
    public Queue<Mail> getEventQueue() {
        return new ConcurrentLinkedQueue<>(messages);
    }

    public List<Mail> getMailByTime(Integer timeFrom, Integer timeTo) {
        ArrayList<Mail> mails = new ArrayList<>();
        for (int i = messages.size() - 1; i >= 0; i--) {
            if (messages.get(i).getDate() >= timeFrom && messages.get(i).getDate() < timeTo) {
                mails.add(messages.get(i));
            } else if (messages.get(i).getDate() < timeFrom) {
                break;
            }
        }
        return mails;
    }


}
