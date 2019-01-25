package org.sadtech.vkbot.core.listener;

public interface EventListener extends Runnable {

    void listen() throws Exception;

}
