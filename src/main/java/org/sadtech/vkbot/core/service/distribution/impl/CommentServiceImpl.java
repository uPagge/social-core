package org.sadtech.vkbot.core.service.distribution.impl;

import org.sadtech.vkbot.core.entity.Comment;
import org.sadtech.vkbot.core.repository.CommentRepository;
import org.sadtech.vkbot.core.service.distribution.CommentService;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.add(comment);
    }
}
