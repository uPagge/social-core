package org.sadtech.vkbot.core.distribution.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.distribution.EventDistributable;
import org.sadtech.vkbot.core.distribution.EventSubscribe;
import org.sadtech.vkbot.core.service.handlers.MailService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MailSubscriber implements EventSubscribe<JsonObject>, EventDistributable {

    public static final Logger log = Logger.getLogger(MailSubscriber.class);

    private MailService mailService;

    private Set<Integer> admins = new HashSet<>();
    private Map<String, EventSubscribe> eventDistributionMap = new HashMap<>();

    public MailSubscriber(EventDistributable eventDistributable, MailService mailService) {
        this.mailService = mailService;
        eventDistributable.registerSubscriber("\"message_new\"", this);
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void setAdmins(Set<Integer> admins) {
        this.admins = admins;
    }

    public Set<Integer> getAdmins() {
        return admins;
    }

    @Override
    public void update(JsonObject object) {
        log.info("Дистрибьютор получил событие - сообщение от пользователя");
        Gson gson = new Gson();
        Message userMessage = gson.fromJson(object.getAsJsonObject("object"), Message.class);
        if (admins.contains(userMessage.getUserId())) {
            log.info("Сообщение отправлено в репозиторий команд");
            eventDistributionMap.get("terminal").update(userMessage);
        } else {
            log.info("Сообщение отправленно на добавление в репозиторий");
            mailService.add(userMessage);
        }
    }


    @Override
    public void distribute() throws Exception {

    }

    @Override
    public void registerSubscriber(String key, EventSubscribe o) {
        eventDistributionMap.put(key, o);
    }

}
