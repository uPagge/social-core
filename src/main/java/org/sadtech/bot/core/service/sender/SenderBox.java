package org.sadtech.bot.core.service.sender;

import org.sadtech.bot.core.domain.BoxAnswer;
import org.sadtech.bot.core.domain.content.BoardComment;
import org.sadtech.bot.core.domain.content.Content;
import org.sadtech.bot.core.exception.MailSendException;

public class SenderBox {

    private SenderBox() {
        throw new IllegalStateException("Utility Class");
    }

    public static void sent(Sent sent, Content content, BoxAnswer boxAnswer) {
        switch (content.getType()) {
            case MAIL:
                sent.send(content.getPersonId(), boxAnswer);
                break;
            case BOARD_COMMENT:
                sent.send(((BoardComment) content).getTopicId(), content.getPersonId(), boxAnswer);
                break;
            default:
                throw new MailSendException();
        }
    }

}
