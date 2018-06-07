package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Like;
import com.demianchuk.messenger.services.LikeService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LikeResource {

    private LikeService likeService = new LikeService();

    @GET
    public Response getAllLikes(@PathParam("messageId") long messageId,
                                  @QueryParam("author") String author) {
        List<Like> likes;
        if(author != null)
            likes = likeService.getAllLikesByAuthor(messageId, author);
        else
            likes = likeService.getAllLikes(messageId);
        GenericEntity<List<Like>> entity = new GenericEntity<List<Like>>(likes){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/{likeId}")
    public Response getLike(@PathParam("messageId") long messageId,
                            @PathParam("likeId") long likeId) {
        Like like = likeService.getLike(messageId, likeId);
        return Response.ok(like).build();
    }

    @POST
    public Response addLike(@PathParam("messageId") long messageId,
                            @Context UriInfo uriInfo,
                            Like like) {
        Like newLike = likeService.addLike(messageId, like);
        String newLikeId = String.valueOf(newLike.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newLikeId).build();
        return Response.created(uri).entity(newLike).build();
    }

    @DELETE
    @Path("/{likeId}")
    public Response deleteLike(@PathParam("messageId") long messageId,
                           @PathParam("likeId") long likeId) {
        Like deletedLike = likeService.deleteLike(messageId, likeId);
        return Response.ok(deletedLike).build();
    }
}
