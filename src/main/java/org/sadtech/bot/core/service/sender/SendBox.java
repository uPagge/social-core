package org.sadtech.bot.core.service.sender;

import org.sadtech.bot.core.domain.BoxAnswer;
import org.sadtech.bot.core.domain.content.Comment;
import org.sadtech.bot.core.domain.content.Message;

public class SendBox {

    private SendBox() {

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
