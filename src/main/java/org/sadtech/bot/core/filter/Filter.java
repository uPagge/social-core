package org.sadtech.bot.core.filter;

import org.sadtech.bot.core.domain.Content;

public interface Filter<T extends Content> {

    void doFilter(T content);

}
