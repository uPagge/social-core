package org.sadtech.vkbot.core.handlers.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.entity.Mail;
import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.handlers.Handled;
import org.sadtech.vkbot.core.handlers.ProcessableEvent;
import org.sadtech.vkbot.core.service.PersonService;
import org.sadtech.vkbot.core.service.handlers.MailService;
import org.sadtech.vkbot.core.service.handlers.SortEventService;
import org.sadtech.vkbot.core.service.handlers.impl.MailServiceImpl;
import org.sadtech.vkbot.core.service.impl.PersonServiceImpl;

public class MailHandlerVk implements ProcessableEvent {

    public static final Logger log = Logger.getLogger(MailHandlerVk.class);

    private PersonService personService;
    private MailService mailService;

    public MailHandlerVk(Handled dispatcherHandler) {
        personService = new PersonServiceImpl();
        mailService = new MailServiceImpl();
        dispatcherHandler.registerObserver("\"message_new\"", this);
    }

    public MailHandlerVk(Handled dispatcherHandler, PersonService personService, MailService mailService) {
        this.personService = personService;
        this.mailService = mailService;
        dispatcherHandler.registerObserver("\"message_new\"", this);
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void update(JsonObject object) {
        Gson gson = new Gson();
        Message userMessage = gson.fromJson(object.getAsJsonObject("object"), Message.class);
        if (!personService.checkPerson(userMessage.getUserId())) {
            Person person = new Person();
            person.setId(userMessage.getUserId());
            log.info("Пользователь отправлен на добавление в репозиторий");
            personService.add(person);
        }
        log.info("Сообщение отправленно на добавление в репозиторий");
        mailService.add(createMail(userMessage));
    }

    private Mail createMail(Message message) {
        Mail mail = new Mail();
        mail.setDate(message.getDate());
        mail.setBody(message.getBody());
        mail.setId(message.getId());
        if (personService.checkPerson(message.getUserId())) {
            mail.setPerson(personService.get(message.getUserId()));
        } else {
            return null;
        }
        return mail;
    }

    @Override
    public SortEventService getServiceEventData() {
        return mailService;
    }
}
