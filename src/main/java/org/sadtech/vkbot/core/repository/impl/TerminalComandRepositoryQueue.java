package org.sadtech.vkbot.core.repository.impl;

import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.repository.EventRepository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TerminalComandRepositoryQueue implements EventRepository<Mail> {

    private Queue<Mail> mailQueue = new ConcurrentLinkedQueue<>();

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
