package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Message;
import com.demianchuk.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
        return messageService.getMessage(messageId);
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message addMessage() {
//        return messageService.addMessage(new Message(3L, "Hello Message", "Kolya"));
//    }
//
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message updateMessage() {
//        return messageService.updateMessage(new Message(1L, "HELLO WORLD!!!", "NICK"));
//    }
//
//    @DELETE
//    @Path("/{messageId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message removeMessage(@PathParam("messageId") long messageId) {
//        return messageService.removeMessage(messageId);
//    }
}