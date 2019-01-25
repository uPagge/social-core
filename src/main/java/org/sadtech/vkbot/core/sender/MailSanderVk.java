package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.entity.Person;

public class MailSanderVk implements MailSandler {

    private Person person;
    private VkApiClient vkApiClient;
    private GroupActor groupActor;

    public MailSanderVk(VkConnect vkConnect) {
        this.vkApiClient = vkConnect.getVkApiClient();
        this.groupActor = vkConnect.getGroupActor();
    }

    public MailSanderVk(Person person, VkConnect vkConnect) {
        this.person = person;
        this.vkApiClient = vkConnect.getVkApiClient();
        this.groupActor = vkConnect.getGroupActor();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void send(String text) {
        try {
            vkApiClient.messages().send(groupActor).userId(person.getId()).message(text).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
