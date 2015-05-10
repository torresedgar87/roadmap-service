package org.dreamers.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dreamers.Main;
import org.dreamers.database.DatabaseConnection;
import org.dreamers.database.UserDatabase;
import org.dreamers.model.User;

@Path("user")
public class UserResource 
{
	private UserDatabase connection = new UserDatabase(Main.connection.getConnection());
	
	@GET
	@Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("email") String email) 
	{		
		User user = null;
		Response response = null;
		try
		{
			user = connection.getUser(email);
		}
		catch(Exception e)
		{
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
		if(user == null)
		{
			response = Response.status(Status.NOT_FOUND).build();
		}
		else
		{
			response = Response.status(Status.OK).entity(user).build();
		}
		
        return response;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user)
	{
		Response response = null;
		try
		{
			connection.createUser(user);
			response = Response.status(Status.OK).build();
		}
		catch(Exception e)
		{
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return response;
	}
}
