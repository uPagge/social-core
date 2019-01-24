package org.sadtech.vkbot.core.repository;

import org.sadtech.vkbot.core.entity.Person;

public interface PersonRepository {

    void add(Person person);

    Person get(Integer id);

}
