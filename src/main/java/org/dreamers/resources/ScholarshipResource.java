package org.dreamers.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("scholarship")
public class ScholarshipResource 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getScholarships()
	{
		return null;
	}
}
