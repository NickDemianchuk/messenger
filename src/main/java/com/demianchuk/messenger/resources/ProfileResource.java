package com.demianchuk.messenger.resources;

import com.demianchuk.messenger.models.Profile;
import com.demianchuk.messenger.services.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.Set;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    @GET
    public Response getProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        GenericEntity<List<Profile>> entity = new GenericEntity<List<Profile>>(profiles){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/{profileName}")
    public Response getProfile(@PathParam("profileName") String profileName) {
        Profile profile = profileService.getProfile(profileName);
        return Response.ok(profile).build();
    }

    @POST
    public Response addProfile(Profile profile, @Context UriInfo uriInfo) {
        Profile newProfile = profileService.addProfile(profile);
        String newProfileName = newProfile.getProfileName();
        URI uri = uriInfo.getAbsolutePathBuilder().path(newProfileName).build();
        return Response.created(uri).entity(newProfile).build();
    }

    @PUT
    @Path("/{profileName}")
    public Response updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        Profile updatedProfile = profileService.updateProfile(profile);
        return Response.accepted(updatedProfile).build();
    }

    @DELETE
    @Path("/{profileName}")
    public Response removeProfile(@PathParam("profileName") String profileName) {
        Profile deletedProfile = profileService.removeProfile(profileName);
        return Response.ok(deletedProfile).build();
    }
}