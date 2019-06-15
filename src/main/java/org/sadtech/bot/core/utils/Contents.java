package org.sadtech.bot.core.utils;

import org.sadtech.bot.core.domain.content.EmptyMessage;

public class Contents {

    private Contents() {
        throw new IllegalStateException("Utility class");
    }

    public static final EmptyMessage EMPTY_CONTENT = new EmptyMessage();


}
