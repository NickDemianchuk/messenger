package com.demianchuk.messenger.services;

import com.demianchuk.messenger.database.DatabaseClass;
import com.demianchuk.messenger.models.Comment;
import com.demianchuk.messenger.models.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    private Map<Long, Comment> getComments(long messageId) {
        return messages.get(messageId).getComments();
    }

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = this.getComments(messageId);
        return new ArrayList<>(comments.values());
    }

    public List<Comment> getAllCommentsByAuthor(long messageId, String author) {
        Map<Long, Comment> comments = this.getComments(messageId);
        return comments.values()
                .stream()
                .filter(c -> c.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> comments = this.getComments(messageId);
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = this.getComments(messageId);
        comment.setId(comments.size() + 1);
        comment.setCreated(LocalDateTime.now());
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        if(comment.getId() <= 0)
            return null;
        comment.setCreated(LocalDateTime.now());
        Map<Long, Comment> comments = this.getComments(messageId);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment deleteComment(long messageId, long commentId) {
        Map<Long, Comment> comments = this.getComments(messageId);
        return comments.remove(commentId);
    }
}
