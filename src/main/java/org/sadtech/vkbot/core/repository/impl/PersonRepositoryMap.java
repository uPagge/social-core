package org.sadtech.vkbot.core.repository.impl;

import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.repository.EventRepository;
import org.sadtech.vkbot.core.repository.PersonRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PersonRepositoryMap implements EventRepository<Person>, PersonRepository {

    private Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    @Override
    public void cleanAll() {
        personMap.clear();
    }

    @Override
    public Queue<Person> getEventQueue() {
        return new ConcurrentLinkedQueue<>(personMap.values());
    }

    @Override
    public Person get(Integer id) {
        return personMap.get(id);
    }
}
