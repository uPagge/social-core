package org.sadtech.social.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadtech.social.core.domain.content.BoardComment;
import org.sadtech.social.core.repository.ContentRepository;
import org.sadtech.social.core.service.MessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements MessageService<BoardComment> {

    private final ContentRepository<BoardComment> commentRepository;

    @Override
    public void add(BoardComment event) {
        commentRepository.add(event);
    }

    @Override
    public List<BoardComment> getByAddDateTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        throw new IllegalStateException("Не реализовано");
    }

    @Override
    public List<BoardComment> getLastEventByCreateDateTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        log.trace("Запрошены последние комментарии к обсуждению {} - {} ", timeFrom, timeTo);
        List<BoardComment> mails = commentRepository.betweenByCreateDateTime(timeFrom, timeTo);
        return getBoardComments(mails);
    }

    @Override
    public List<BoardComment> getLastEventByAddDateTime(LocalDateTime timeFrom, LocalDateTime timeTo) {
        log.trace("Запрошены последние комментарии к обсуждению {} - {} ", timeFrom, timeTo);
        List<BoardComment> mails = commentRepository.betweenByAddDateTime(timeFrom, timeTo);
        return getBoardComments(mails);
    }

    @Override
    public List<BoardComment> getNewMessage() {
        throw new IllegalStateException("Не реализовано");
    }

    private List<BoardComment> getBoardComments(List<BoardComment> mails) {
        Set<Long> people = new HashSet<>();
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
