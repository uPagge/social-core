package org.sadtech.bot.core.domain.content;

import java.util.Objects;

public abstract class Comment extends Message {

    private Integer contentId;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        if (!super.equals(o)) return false;
        Comment that = (Comment) o;
        return Objects.equals(contentId, that.contentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contentId);
    }
}
