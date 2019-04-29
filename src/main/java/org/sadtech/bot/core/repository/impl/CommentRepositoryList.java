package org.sadtech.bot.core.repository.impl;

import org.sadtech.bot.core.domain.Comment;
import org.sadtech.bot.core.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryList implements CommentRepository {

    private List<Comment> comments = new ArrayList<>();

    @Override
    public void add(Comment comment) {
        comments.add(comment);
    }
}
