package com.demianchuk.messenger.models;

import java.util.Date;

public class Like {

    private long id;
    private String author;
    private Date created;

    public Like() {}

    public Like(long id, String author) {
        this.id = id;
        this.author = author;
        this.created = new Date();
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
