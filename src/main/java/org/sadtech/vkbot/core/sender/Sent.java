package org.sadtech.vkbot.core.sender;

import org.sadtech.vkbot.core.entity.BoxAnswer;

public interface Sent {

    void send(Integer idPerson, String message);

    void send(Integer idPerson, BoxAnswer boxAnswer);

}
