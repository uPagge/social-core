package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.VkInsertData;
import org.sadtech.vkbot.core.entity.MailSend;
import org.sadtech.vkbot.core.insert.InsertWords;

import java.util.List;

public class MailSanderVk implements MailSandler {

    public static final Logger log = Logger.getLogger(MailSanderVk.class);

    private VkApiClient vkApiClient;
    private GroupActor groupActor;

    private VkInsertData vkInsertData;

    public MailSanderVk(VkConnect vkConnect) {
        this.vkApiClient = vkConnect.getVkApiClient();
        this.groupActor = vkConnect.getGroupActor();
        this.vkInsertData = new VkInsertData(vkConnect);
    }

    private MessagesSendQuery createMessage (MailSend mailSend, Integer idUser) {
        MessagesSendQuery messages = vkApiClient.messages().send(groupActor).peerId(idUser);
        if (mailSend.getKeyboard() != null) {
            messages.keyboard(mailSend.getKeyboard());
        } else {
            messages.keyboard("{\"buttons\":[],\"one_time\":true}");
        }
        if (mailSend.getLat() != null && mailSend.getaLong() != null) {
            messages.lat(mailSend.getLat()).lng(mailSend.getaLong());
        }
        if (mailSend.getStickerId() != null) {
            try {
                vkApiClient.messages().send(groupActor).peerId(idUser).stickerId(mailSend.getStickerId()).execute();
            } catch (ApiException | ClientException e) {
                e.printStackTrace();
            }
        }
        return messages;
    }

    @Override
    public void send(MailSend mailSend, Integer idUser) {
        MessagesSendQuery messages = createMessage(mailSend, idUser);
        if (mailSend.getMessage() != null) {
            messages.message(vkInsertData.insertWords(mailSend, idUser));
        }
        sendMessage(messages);
    }

    public void send(MailSend mailSend, Integer idUser, List<String> insertWords) {
        MessagesSendQuery messages = createMessage(mailSend, idUser);
        if (mailSend.getMessage() != null) {
            InsertWords insert = new InsertWords();
            insert.setInText(vkInsertData.insertWords(mailSend, idUser));
            insert.insert(insertWords);
            messages.message(insert.getOutText());
        }
        sendMessage(messages);
    }

    private void sendMessage(MessagesSendQuery messages) {
        try {
            messages.execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
