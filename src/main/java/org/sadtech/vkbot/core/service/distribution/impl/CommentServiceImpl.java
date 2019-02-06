package org.sadtech.vkbot.core.service.distribution.impl;

import org.sadtech.vkbot.core.entity.Comment;
import org.sadtech.vkbot.core.repository.CommentRepository;
import org.sadtech.vkbot.core.service.distribution.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.add(comment);
    }

    @Override
    public List<Comment> getEvent(Integer timeFrom, Integer timeTo) {
        return null;
    }

    @Override
    public List<Comment> getFirstMailByTime(Integer timeFrom, Integer timeTo) {
        return null;
    }

    @Override
    public List<Comment> getLastMailByTime(Integer timeFrom, Integer timeTo) {
        return null;
    }
}
