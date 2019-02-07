package org.sadtech.vkbot.core.listener;

import com.google.gson.JsonObject;
import com.vk.api.sdk.actions.LongPoll;
import com.vk.api.sdk.callback.longpoll.queries.GetLongPollEventsQuery;
import com.vk.api.sdk.callback.longpoll.responses.GetLongPollEventsResponse;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.groups.responses.GetLongPollServerResponse;
import org.apache.log4j.Logger;
import org.sadtech.vkbot.core.VkConnect;
import org.sadtech.vkbot.core.repository.impl.EventRepositoryQueue;
import org.sadtech.vkbot.core.service.RawEventService;
import org.sadtech.vkbot.core.service.impl.RawEventServiceImpl;

public class EventListenerVk implements EventListener, Runnable {

    public static final Logger log = Logger.getLogger(EventListenerVk.class);

    private VkApiClient vk;
    private GroupActor actor;

    private RawEventService rawEventService;

    private GetLongPollEventsQuery longPollEventsQuery;
    private LongPoll longPoll;
    private GetLongPollServerResponse server;

    public EventListenerVk(VkConnect vkConnect) {
        vk = vkConnect.getVkApiClient();
        actor = vkConnect.getGroupActor();
        rawEventService = new RawEventServiceImpl(new EventRepositoryQueue());
        longPoll = new LongPoll(vk);
    }

    public EventListenerVk(VkConnect vkConnect, RawEventService rawEventService) {
        this.vk = vkConnect.getVkApiClient();
        this.actor = vkConnect.getGroupActor();
        this.rawEventService = rawEventService;
        longPoll = new LongPoll(vk);
    }

    public RawEventService getRawEventService() {
        return rawEventService;
    }

    public void listen() throws ClientException, ApiException {
        initServer();
        log.info("LongPollServer инициализирован");
        do {
            GetLongPollEventsResponse eventsResponse;
            eventsResponse = longPollEventsQuery.execute();
            if (eventsResponse.getUpdates().toArray().length != 0) {
                log.info("Полученно событие от ВК");
                log.info(eventsResponse.getUpdates());
                for (JsonObject update : eventsResponse.getUpdates()) {
                    rawEventService.add(update);
                }
            }
            longPollEventsQuery = longPoll.getEvents(server.getServer(), server.getKey(), eventsResponse.getTs()).waitTime(20);
        } while (true);
    }

    private void initServer() throws ClientException, ApiException {
        server = vk.groups().getLongPollServer(actor).execute();
        String key = server.getKey();
        String serverUrl = server.getServer();
        Integer ts = server.getTs();
        longPoll = new LongPoll(vk);
        longPollEventsQuery = longPoll.getEvents(serverUrl, key, ts).waitTime(20);
    }

    @Override
    public void run() {
        try {
            listen();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
        }
    }

}
