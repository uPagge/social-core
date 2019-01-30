package org.sadtech.vkbot.core.sender;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.entity.MailSend;

public class MailSanderVk implements MailSandler {

    public static final Logger log = Logger.getLogger(MailSanderVk.class);

    private VkApiClient vkApiClient;
    private GroupActor groupActor;

    public MailSanderVk(VkConnect vkConnect) {
        this.vkApiClient = vkConnect.getVkApiClient();
        this.groupActor = vkConnect.getGroupActor();
    }

    @Override
    public void send(MailSend mailSend) {
        MessagesSendQuery messages = vkApiClient.messages().send(groupActor).peerId(mailSend.getIdRecipient());
        if (mailSend.getMessage() != null) {
            messages.message(mailSend.getMessage());
        }
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
                vkApiClient.messages().send(groupActor).peerId(mailSend.getIdRecipient()).stickerId(mailSend.getStickerId()).execute();
            } catch (ApiException | ClientException e) {
                e.printStackTrace();
            }
        }

        try {
            log.info(mailSend);
            messages.execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
