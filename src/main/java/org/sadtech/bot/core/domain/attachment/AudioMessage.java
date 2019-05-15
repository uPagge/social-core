package org.sadtech.bot.core.domain.attachment;

import java.net.URL;

public class AudioMessage extends Attachment {

    private URL linkOdd;

    public AudioMessage() {
        type = AttachmentType.AUDIO_MESSAGE;
    }

    public URL getLinkOdd() {
        return linkOdd;
    }

    public void setLinkOdd(URL linkOdd) {
        this.linkOdd = linkOdd;
    }
}
