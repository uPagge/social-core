package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.insert.VkInsertData;
import org.sadtech.vkbot.core.entity.MailSend;
import org.sadtech.vkbot.core.insert.InsertWords;

import java.util.List;

public class MailSenderVk implements MailSent {

    public static final Logger log = Logger.getLogger(MailSenderVk.class);

    private VkApiClient vkApiClient;
    private GroupActor groupActor;

    private VkInsertData vkInsertData;

    public MailSenderVk(VkConnect vkConnect) {
        this.vkApiClient = vkConnect.getVkApiClient();
        this.groupActor = vkConnect.getGroupActor();
        this.vkInsertData = new VkInsertData(vkConnect);
    }

    private MessagesSendQuery createMessage(MailSend mailSend, Integer peerId) {
        MessagesSendQuery messages = vkApiClient.messages().send(groupActor).peerId(peerId);
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
                vkApiClient.messages().send(groupActor).peerId(peerId).stickerId(mailSend.getStickerId()).execute();
            } catch (ApiException | ClientException e) {
                e.printStackTrace();
            }
        }
        return messages;
    }

    @Override
    public void send(MailSend mailSend, Integer peerId, Integer userId) {
        MessagesSendQuery messages = createMessage(mailSend, peerId);
        if (mailSend.getMessage() != null) {
            messages.message(vkInsertData.insertWords(mailSend, userId));
        }
        sendMessage(messages);
    }

    @Override
    public void send(MailSend mailSend, Integer peerId, Integer userId, List<String> insertWords) {
        MessagesSendQuery messages = createMessage(mailSend, peerId);
        if (mailSend.getMessage() != null) {
            InsertWords insert = new InsertWords();
            insert.setInText(vkInsertData.insertWords(mailSend, peerId));
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
