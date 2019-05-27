package org.sadtech.bot.core.service;

import org.sadtech.bot.core.domain.content.Content;

@FunctionalInterface
public interface Filter<T extends Content> {

    void processing(T content);

}
