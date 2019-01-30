package org.sadtech.vkbot.core.service;

import com.vk.api.sdk.objects.users.User;
import com.vk.api.sdk.objects.users.UserMin;
import org.sadtech.vkbot.core.entity.Person;

public interface PersonService {

    void add(User person);

    void add(Person person);

    void add(UserMin userMin);

    Person get(Integer id);

    boolean checkPerson(Integer idPerson);

    Person createPerson(Integer userId);
}
