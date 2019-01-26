package org.sadtech.vkbot.core.sender;

import org.sadtech.vkbot.core.entity.Person;

public interface MailSandler {

    void send(String text);

    void setPerson(Person person);

    void send(String text, String keyBoard);

}
