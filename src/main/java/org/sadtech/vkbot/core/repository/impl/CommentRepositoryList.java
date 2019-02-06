package org.sadtech.vkbot.core.repository.impl;

import org.sadtech.vkbot.core.entity.Comment;
import org.sadtech.vkbot.core.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryList implements CommentRepository {

    private List<Comment> comments = new ArrayList<>();

    @Override
    public void add(Comment comment) {
        comments.add(comment);
    }
}
