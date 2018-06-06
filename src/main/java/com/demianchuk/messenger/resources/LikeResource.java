package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Like;
import com.demianchuk.messenger.services.LikeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LikeResource {

    private LikeService likeService = new LikeService();

    @GET
    public List<Like> getAllLikes(@PathParam("messageId") long messageId,
                                  @QueryParam("author") String author) {
        if(author != null)
            return likeService.getAllLikesByAuthor(messageId, author);
        return likeService.getAllLikes(messageId);
    }

    @GET
    @Path("/{likeId}")
    public Like getLike(@PathParam("messageId") long messageId,
                        @PathParam("likeId") long likeId) {
        return likeService.getLike(messageId, likeId);
    }

    @POST
    public Like addLike(@PathParam("messageId") long messageId, Like like) {
        return likeService.addLike(messageId, like);
    }

    @DELETE
    @Path("/{likeId}")
    public Like deleteLike(@PathParam("messageId") long messageId,
                           @PathParam("likeId") long likeId) {
        return likeService.deleteLike(messageId, likeId);
    }
}
