package org.sadtech.vkbot.core.listener;

public interface EventListenable extends Runnable {

    void listen() throws Exception;

}
