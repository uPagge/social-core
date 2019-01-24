package org.sadtech.vkbot.core.handlers;

import org.sadtech.vkbot.core.service.EventService;

public interface Handled extends Runnable {

    void sortAndSend() throws Exception;

    void registerObserver(String key, ProcessableEvent o);

    EventService getResponsibleService();

}
