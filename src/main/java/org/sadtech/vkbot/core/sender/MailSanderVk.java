package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.entity.Person;

public class MailSanderVk implements MailSandler {

    private Person person;

    private Integer idRecipient;
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

    public void setIdRecipient(Integer idRecipient) {
        this.idRecipient = idRecipient;
    }

    public void setPerson(Person person) {
        idRecipient = person.getId();
    }

    @Override
    public void send(String text, String keyBoard) {
        try {
            vkApiClient.messages().send(groupActor).peerId(idRecipient).keyboard(keyBoard).message(text).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String text) {
        try {
            vkApiClient.messages().send(groupActor).userId(idRecipient).message(text).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
