package com.demianchuk.messenger.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Like {

    private long id;
    private String author;
    private LocalDateTime created;

    public Like() {}

    public Like(long id, String author) {
        this.id = id;
        this.author = author;
        this.created = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
