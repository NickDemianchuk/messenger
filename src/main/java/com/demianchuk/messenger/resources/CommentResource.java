package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Comment;
import com.demianchuk.messenger.services.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId,
                                        @QueryParam("author") String author) {
        if(author != null)
            return commentService.getAllCommentsByAuthor(messageId, author);
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long commentId,
                                 Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long commentId) {
        return commentService.deleteComment(messageId, commentId);
    }
}
