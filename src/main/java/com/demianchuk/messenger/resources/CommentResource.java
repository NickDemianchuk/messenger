package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Comment;
import com.demianchuk.messenger.services.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public Response getAllComments(@PathParam("messageId") long messageId,
                                   @QueryParam("author") String author) {
        List<Comment> comments;
        if (author != null)
            comments = commentService.getAllCommentsByAuthor(messageId, author);
        else
            comments = commentService.getAllComments(messageId);
        GenericEntity<List<Comment>> entity = new GenericEntity<List<Comment>>(comments){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/{commentId}")
    public Response getComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        Comment comment = commentService.getComment(messageId, commentId);
        return Response.ok(comment).build();
    }

    @POST
    public Response addComment(@PathParam("messageId") long messageId,
                               @Context UriInfo uriInfo,
                               Comment comment) {
        Comment newComment = commentService.addComment(messageId, comment);
        String newCommentId = String.valueOf(newComment.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newCommentId).build();
        return Response.created(uri).entity(newComment).build();
    }

    @PUT
    @Path("/{commentId}")
    public Response updateComment(@PathParam("messageId") long messageId,
                                           @PathParam("commentId") long commentId,
                                           Comment comment) {
        comment.setId(commentId);
        Comment updatedComment = commentService.updateComment(messageId, comment);
        return Response.accepted(updatedComment).build();
    }

    @DELETE
    @Path("/{commentId}")
    public Response deleteComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long commentId) {
        Comment deletedComment = commentService.deleteComment(messageId, commentId);
        return Response.ok(deletedComment).build();
    }
}
