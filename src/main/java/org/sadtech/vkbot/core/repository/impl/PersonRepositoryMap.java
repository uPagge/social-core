package org.sadtech.vkbot.core.repository.impl;

import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.repository.PersonRepository;

import java.util.HashMap;
import java.util.Map;

public class PersonRepositoryMap implements PersonRepository {

    private Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    @Override
    public Person get(Integer id) {
        return personMap.get(id);
    }
}
