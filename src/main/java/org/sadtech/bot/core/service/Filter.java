package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.content.Message;

@FunctionalInterface
public interface Filter<T extends Message> {

    void processing(T content);

}
