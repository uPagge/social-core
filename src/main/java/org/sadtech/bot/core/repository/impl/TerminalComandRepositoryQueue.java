package org.sadtech.bot.core.repository.impl;

import org.sadtech.bot.core.domain.Mail;
import org.sadtech.bot.core.repository.EventRepository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TerminalComandRepositoryQueue implements EventRepository<Mail> {

    private final Queue<Mail> mailQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void add(Mail dataObject) {
        mailQueue.offer(dataObject);
    }

    @Override
    public void cleanAll() {
        mailQueue.clear();
    }

    @Override
    public Queue<Mail> getEventQueue() {
        return mailQueue;
    }
}
