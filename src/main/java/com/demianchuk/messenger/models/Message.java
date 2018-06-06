package com.demianchuk.messenger.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Message {

    private long id;
    private String messageContent;
    private LocalDateTime created;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();
    private Map<Long, Like> likes = new HashMap<>();

    public Message () {}

    public Message(long id, String messageContent, String author) {
        this.id = id;
        this.messageContent = messageContent;
        this.created = LocalDateTime.now();
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Map<Long, Like> getLikes() {
        return likes;
    }

    public void setLikes(Map<Long, Like> likes) {
        this.likes = likes;
    }
}
