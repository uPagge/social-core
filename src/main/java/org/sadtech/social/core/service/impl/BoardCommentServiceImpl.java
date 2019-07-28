package org.sadtech.social.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadtech.social.core.domain.content.BoardComment;
import org.sadtech.social.core.repository.ContentRepository;
import org.sadtech.social.core.service.BoardCommentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements BoardCommentService {

    private final ContentRepository<BoardComment> commentRepository;

    @Override
    public void add(BoardComment event) {
        commentRepository.add(event);
    }

    @Override
    public List<BoardComment> getByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        return null;
    }

    @Override
    public List<BoardComment> getLastEventByTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        log.info("Запрошены последние комментарии к обсуждению {} - {} ", timeFrom, timeTo);
        List<BoardComment> mails = commentRepository.betweenByTime(timeFrom, timeTo);
        Set<Integer> people = new HashSet<>();
        List<BoardComment> returnMails = new ArrayList<>();
        for (int i = mails.size() - 1; i >= 0; i--) {
            if (!people.contains(mails.get(i).getPersonId())) {
                returnMails.add(mails.get(i));
                people.add(mails.get(i).getPersonId());
            }
        }
        return returnMails;
    }
}
