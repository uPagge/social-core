package org.sadtech.vkbot.core.repository.impl;

import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.repository.MailRepository;

import java.util.ArrayList;
import java.util.List;

public class MailRepositoryList implements MailRepository {

    private List<Mail> messages = new ArrayList<>();

    @Override
    public void add(Mail mail) {
        messages.add(mail);
    }

    @Override
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