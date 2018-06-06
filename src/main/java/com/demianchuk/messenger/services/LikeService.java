package com.demianchuk.messenger.services;


import com.demianchuk.messenger.database.DatabaseClass;
import com.demianchuk.messenger.models.Like;
import com.demianchuk.messenger.models.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LikeService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    private Map<Long, Like> getLikes(long messageId) {
        return messages.get(messageId).getLikes();
    }

    public List<Like> getAllLikes(long messageId) {
        Map<Long, Like> likes = this.getLikes(messageId);
        return new ArrayList<>(likes.values());
    }

    public List<Like> getAllLikesByAuthor(long messageId, String author) {
        Map<Long, Like> likes = this.getLikes(messageId);
        return likes.values()
                .stream()
                .filter(l -> l.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Like getLike(long messageId, long likeId) {
        Map<Long, Like> likes = this.getLikes(messageId);
        return likes.get(likeId);
    }

    public Like addLike(long messageId, Like like) {
        Map<Long, Like> likes = this.getLikes(messageId);
        like.setId(likes.size() + 1);
        like.setCreated(LocalDateTime.now());
        likes.put(like.getId(), like);
        return like;
    }

    public Like deleteLike(long messageId, long likeId) {
        Map<Long, Like> likes = this.getLikes(messageId);
        return likes.remove(likeId);
    }
}