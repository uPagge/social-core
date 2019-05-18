package org.sadtech.bot.core.domain.attachment;

import java.net.URL;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AudioMessage)) return false;
        AudioMessage that = (AudioMessage) o;
        return Objects.equals(linkOdd, that.linkOdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkOdd);
    }

    @Override
    public String toString() {
        return "AudioMessage{" +
                "linkOdd=" + linkOdd +
                ", type=" + type +
                '}';
    }
}
