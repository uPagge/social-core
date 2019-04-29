package org.sadtech.bot.core.repository;

import org.sadtech.bot.core.domain.Person;

public interface PersonRepository {

    void add(Person person);

    Person get(Integer id);

}
