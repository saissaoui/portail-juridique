package fr.artefrance.daj.rest;


import fr.artefrance.daj.domain.statement.artwork.Artwork;
import fr.artefrance.daj.service.artwork.ArtworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Path("/artworks")
@Produces(MediaType.APPLICATION_JSON)
public class ArtworkResource {

    private ArtworkService artworkService;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);

    @Autowired
    public ArtworkResource(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GET
    @Path("/{artworkId}")
    public Response artwork(@PathParam("artworkId") int artworkId) {

        Artwork artwork = this.artworkService.findArtworkById((long) artworkId);
        LOGGER.info("artwork = " + artwork);

        return Response.status(OK)
                       .entity(artwork)
                       .build();
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createArtwork(Artwork artwork) {

        Artwork createdArtwork = this.artworkService.create(artwork);
        LOGGER.info("createdArtwork = " + createdArtwork);
        return Response.status(CREATED)
                       .header(HttpHeaders.LOCATION, "artworks/" + createdArtwork.getId())
                       .build();
    }
}
