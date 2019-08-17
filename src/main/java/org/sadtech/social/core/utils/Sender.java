package org.sadtech.social.core.utils;

import org.sadtech.social.core.domain.BoxAnswer;
import org.sadtech.social.core.domain.content.Comment;
import org.sadtech.social.core.domain.content.Message;
import org.sadtech.social.core.service.sender.Sending;

import static org.sadtech.social.core.utils.ExceptionMessages.UTILITY_CLASS;

public class Sender {

    private Sender() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    public static void sends(Message message, BoxAnswer boxAnswer, Sending sending) {
        switch (sending.getType()) {
            case PUBLIC:
                publicSend(message, boxAnswer, sending);
                break;
            case PRIVATE:
                privateSend(message, boxAnswer, sending);
                break;
        }
    }

    private static void publicSend(Message message, BoxAnswer boxAnswer, Sending sending) {
        if (message instanceof Comment) {
            sending.send(((Comment) message).getContentId(), message.getPersonId(), boxAnswer);
        }
    }

    private static void privateSend(Message message, BoxAnswer boxAnswer, Sending sending) {
        sending.send(message.getPersonId(), boxAnswer);
    }

}
