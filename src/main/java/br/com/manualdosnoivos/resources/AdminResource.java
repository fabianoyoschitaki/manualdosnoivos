package br.com.manualdosnoivos.resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * WebService RESTful
 * 
 * @author fabiano
 *
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {

	@GET
	@Path("/variables")
	public Map<String, String> getEnvironmentalVariables(){
		return System.getenv();
	}
	
	@GET
	@Path("/variable/{variable}")
	public String getEnvironmentalVariable(@PathParam("variable")String variable){
		return System.getenv(variable);
	}
}
