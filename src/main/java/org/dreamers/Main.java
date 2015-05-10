
package org.dreamers;

import org.dreamers.database.DatabaseConnection;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;


public class Main {

	public static DatabaseConnection connection = null;
	private static HttpServer httpServer = null;
	
    private static URI getBaseURI() 
    {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public static final URI BASE_URI = getBaseURI();
    
    protected static HttpServer startServer() throws Exception 
    {
    	ResourceConfig rc = new ResourceConfig().packages("org.dreamers.resources");
    	
        System.out.println("Starting grizzly2...");
        connection = new DatabaseConnection();
        connection.open();
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }
    
    protected static void closeServer() throws Exception
    {
    	connection.close();
    	httpServer.shutdown();
    }
    
    public static void main(String[] args) throws Exception 
    {
        httpServer = startServer();
        System.in.read();
        closeServer();
    }    
}
