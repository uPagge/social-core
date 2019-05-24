package org.sadtech.bot.core.utils;

import org.sadtech.bot.core.domain.EmptyContent;

public class Contents {

    private Contents() {
        throw new IllegalStateException("Utility class");
    }

    public static final EmptyContent EMPTY_CONTENT = new EmptyContent();


}
