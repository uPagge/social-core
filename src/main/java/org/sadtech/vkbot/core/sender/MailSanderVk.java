package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.entity.Person;
import org.sadtech.vkbot.core.keyboard.KeyBoard;

public class MailSanderVk {

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

    public void sendText(String messageText) {
        try {
            vkApiClient.messages().send(groupActor).userId(person.getId()).message(messageText).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendTextandKeyBoard(String message, KeyBoard keyBoard) {
        try {
            vkApiClient.messages().send(groupActor).userId(person.getId()).message(message).keyboard(keyBoard.getKeyboard(true).toString()).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

}
