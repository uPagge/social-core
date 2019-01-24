package org.sadtech.vkbot.core.handlers;

import com.google.gson.JsonObject;
import org.sadtech.vkbot.core.service.handlers.SortEventService;

public interface ProcessableEvent {

    void update(JsonObject object);

    SortEventService getServiceEventData();

}
