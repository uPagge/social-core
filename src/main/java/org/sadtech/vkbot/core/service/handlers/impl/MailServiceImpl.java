package org.sadtech.vkbot.core.service.handlers.impl;

import com.vk.api.sdk.objects.messages.Message;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.repository.MailRepository;
import org.sadtech.vkbot.core.repository.impl.MailRepositoryList;
import org.sadtech.vkbot.core.service.PersonService;
import org.sadtech.vkbot.core.service.handlers.MailService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MailServiceImpl implements MailService {

    public static final Logger log = Logger.getLogger(MailServiceImpl.class);

    private MailRepository mailRepository;
    private PersonService personService;

    public MailServiceImpl(PersonService personService) {
        this.mailRepository = new MailRepositoryList();
        this.personService = personService;
    }

    public MailServiceImpl(MailRepository mailRepository, PersonService personService) {
        this.mailRepository = mailRepository;
        this.personService = personService;
    }

    @Override
    public void add(Mail mail) {
        mailRepository.add(mail);
        log.info("Сообщение добавлено в репозиторий");
    }

    @Override
    public void add(Message message) {
        Mail mail = new Mail();
        mail.setDate(message.getDate());
        if (!message.getFromId().equals(message.getPeerId())) {
            mail.setBody(message.getBody().replaceFirst("\\[club([0-9]+)\\|\\@\\w+] ", ""));
        } else {
            mail.setBody(message.getBody());
        }
        mail.setId(message.getId());
        mail.setPeerId(message.getPeerId());
        if (!personService.checkPerson(message.getFromId())) {
            personService.add(personService.createPerson(message.getFromId()));
        }
        mail.setPerson(personService.get(message.getFromId()));
        log.info("Сообщение добавлено в репозиторий");
        mailRepository.add(mail);
    }

    private void clean() {

    }

    @Override
    public List<Mail> getFirstMailByTime(Integer timeFrom, Integer timeTo) {
        log.info("Запрошены сообщения от " + timeFrom + " до " + timeTo);
        List<Mail> mails = mailRepository.getMailByTime(timeFrom, timeTo);
        Set<Person> people = new HashSet<>();
        List<Mail> returnMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!people.contains(mails.get(i).getPerson())) {
                returnMails.add(mails.get(i));
                people.add(mails.get(i).getPerson());
            }
        }
        return returnMails;
    }

    @Override
    public List<Mail> getLastMailByTime(Integer timeFrom, Integer timeTo) {
        List<Mail> mails = mailRepository.getMailByTime(timeFrom, timeTo);
        Set<Person> people = new HashSet<>();
        List<Mail> returnMails = new ArrayList<>();
        for (Mail mail : mails) {
            if (!people.contains(mail.getPerson())) {
                returnMails.add(mail);
                people.add(mail.getPerson());
            }
        }
        return returnMails;
    }

    @Override
    public List<Mail> getEvent(Integer timeFrom, Integer timeTo) {
        log.info("Запрос на получение сообщений в интервале от " + timeFrom + " до " + timeTo);
        return mailRepository.getMailByTime(timeFrom, timeTo);
    }

}
