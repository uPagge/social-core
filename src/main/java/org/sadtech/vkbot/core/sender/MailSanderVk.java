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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public void send(MailSend mailSend) {
        MessagesSendQuery messages = vkApiClient.messages().send(groupActor).peerId(mailSend.getIdRecipient());
        if (mailSend.getMessage() != null) {
            messages.message(insertWords(mailSend));
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

    private String insertWords(MailSend mailSend) {
        vkInsertData.setUserId(mailSend.getIdRecipient());

        Pattern pattern = Pattern.compile("\\%(\\w+)%");
        Matcher m = pattern.matcher(mailSend.getMessage());
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(result, vkInsertData.insert(m.group(0)));
        }
        m.appendTail(result);
        return result.toString();
    }
}
