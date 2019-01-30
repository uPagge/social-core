package org.sadtech.vkbot.core.distribution;

public interface EventDistributable {

    void distribute() throws Exception;

    void registerSubscriber(String key, EventSubscribe o);

}
