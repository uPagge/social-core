package org.sadtech.social.core.service.sender;

import org.sadtech.social.core.domain.BoxAnswer;
import org.sadtech.social.core.domain.content.Comment;
import org.sadtech.social.core.domain.content.Message;

public class SendBox {

    private SendBox() {
        throw new IllegalStateException("Утилитный класс");
    }

    public static void sent(Message message, BoxAnswer boxAnswer, Sent sent) {
        switch (message.getType()) {
            case BOARD_COMMENT:
                sent.send(((Comment) message).getContentId(), message.getPersonId(), boxAnswer);
                break;
            case MAIL:
                sent.send(message.getPersonId(), boxAnswer);
                break;
            default:
                sent.send(message.getPersonId(), boxAnswer);
        }
    }

}
