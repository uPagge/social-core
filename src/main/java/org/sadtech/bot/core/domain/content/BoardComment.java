package org.sadtech.bot.core.domain.content;

import java.util.Objects;

public class BoardComment extends Content {

    private Integer topicId;

    public BoardComment() {
        type = ContentType.BOARD_COMMENT;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardComment)) return false;
        if (!super.equals(o)) return false;
        BoardComment that = (BoardComment) o;
        return Objects.equals(topicId, that.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topicId);
    }

    @Override
    public String toString() {
        return "BoardComment{" +
                "topicId=" + topicId +
                "} " + super.toString();
    }
}
