package org.sadtech.bot.core.sender;

import org.sadtech.bot.core.domain.BoxAnswer;

public interface Sent {

    void send(Integer personId, String message);

    void send(Integer personId, BoxAnswer boxAnswer);

}
