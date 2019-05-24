package org.sadtech.bot.core.service.filter;

import org.sadtech.bot.core.domain.content.Content;

public interface Filter<T extends Content> {

    void processing(T content);

}
