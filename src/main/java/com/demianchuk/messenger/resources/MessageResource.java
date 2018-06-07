package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Message;
import com.demianchuk.messenger.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public Response getMessages(@QueryParam("year") int year) {
        List<Message> messages;
        if(year > 0)
            messages = messageService.getAllMessagesForYear(year);
        else
            messages = messageService.getAllMessages();
        GenericEntity<List<Message>> entity = new GenericEntity<List<Message>>(messages){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/{messageId}")
    public Response getMessage(@PathParam("messageId") long messageId) {
        Message message = messageService.getMessage(messageId);
        return Response.ok(message).build();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = messageService.addMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri).entity(newMessage).build();
    }

    @PUT
    @Path("/{messageId}")
    public Response updateMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        Message newMessage = messageService.updateMessage(message);
        return Response.accepted(newMessage).build();
    }

    @DELETE
    @Path("/{messageId}")
    public Response removeMessage(@PathParam("messageId") long messageId) {
        Message deletedMessage = messageService.removeMessage(messageId);
        return Response.ok(deletedMessage).build();
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

    @Path("/{messageId}/likes")
    public LikeResource getLikeResource() {
        return new LikeResource();
    }
}