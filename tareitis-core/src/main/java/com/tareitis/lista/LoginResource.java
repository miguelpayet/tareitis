package com.tareitis.lista;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/login")
@Produces({ "application/json" })
public class LoginResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginResource.class);

	public LoginResource() {
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response realizarLogin(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("remember") String rememberMe, @Context UriInfo uriInfo) {
		LOGGER.info("LoginResource.realizarLogin");
		LOGGER.info(String.format("usuario: %s - password: %s,  rememberMe: %s", username, password, rememberMe)
				.toString());
		Subject s = SecurityUtils.getSubject();
		if (s.isAuthenticated()) {
			LOGGER.info("yay!");
		} else {
			LOGGER.info("nay!");
		}
		URI uri = uriInfo.getAbsolutePath();
		ResponseBuilder rb = Response.created(uri);
		rb.status(401);
		Response r = rb.build();
		return r;
	}

}