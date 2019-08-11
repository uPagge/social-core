package org.sadtech.social.core.repository.impl.local;

import org.sadtech.social.core.domain.content.BoardComment;
import org.sadtech.social.core.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardCommentRepositoryMap implements ContentRepository<BoardComment> {

    private final Map<Integer, BoardComment> saveMap = new HashMap<>();
    private Integer count = 0;

    @Override
    public Integer add(BoardComment comment) {
        comment.setId(count);
        saveMap.put(count, comment);
        return count++;
    }

    @Override
    public List<BoardComment> betweenByCreateDateTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        ArrayList<BoardComment> rezultMails = new ArrayList<>();
        for (int i = saveMap.size() - 1; i >= 0; i--) {
            if (!(saveMap.get(i).getCreateDate().isBefore(timeFrom) || saveMap.get(i).getCreateDate().isAfter(timeTo)) && saveMap.get(i).getCreateDate().equals(timeFrom)) {
                rezultMails.add(this.saveMap.get(i));
            } else if (saveMap.get(i).getCreateDate().isBefore(timeFrom)) {
                break;
            }
        }
        return rezultMails;
    }

    @Override
    public List<BoardComment> betweenByAddDateTime(LocalDateTime from, LocalDateTime to) {
        ArrayList<BoardComment> rezultMails = new ArrayList<>();
        for (int i = saveMap.size() - 1; i >= 0; i--) {
            if (!(saveMap.get(i).getAddDate().isBefore(from) || saveMap.get(i).getAddDate().isAfter(to)) && saveMap.get(i).getAddDate().equals(from)) {
                rezultMails.add(this.saveMap.get(i));
            } else if (saveMap.get(i).getCreateDate().isBefore(to)) {
                break;
            }
        }
        return rezultMails;
    }

}
