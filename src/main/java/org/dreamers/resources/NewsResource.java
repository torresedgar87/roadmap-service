package org.dreamers.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dreamers.model.News;

@Path("news")
public class NewsResource 
{
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNews() {
        return Response.status(Status.OK).entity(new News()).build();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNews(News news)
	{
		return null;
	}
}
