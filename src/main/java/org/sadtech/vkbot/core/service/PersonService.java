package org.sadtech.vkbot.core.service;

import com.vk.api.sdk.objects.users.User;
import org.sadtech.vkbot.core.entity.Person;

public interface PersonService {

    void add(User person);

    void add(Person person);

    Person get(Integer id);

    boolean checkPerson(Integer idPerson);

}
