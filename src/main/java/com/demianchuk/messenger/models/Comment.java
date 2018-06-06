package com.demianchuk.messenger.models;

import java.time.LocalDateTime;

public class Comment {

    private long id;
    private String commentContent;
    private LocalDateTime created;
    private String author;

    public Comment() {}

    public Comment(long id, String commentContent, String author) {
        this.id = id;
        this.commentContent = commentContent;
        this.author = author;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
