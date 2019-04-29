package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.Person;

public interface PersonService {

    void add(Person person);

    Person get(Integer id);

    boolean checkPerson(Integer idPerson);

    Person createPerson(Integer userId);

}
