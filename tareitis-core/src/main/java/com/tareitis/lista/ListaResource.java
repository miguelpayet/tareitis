package com.tareitis.lista;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

@Path("/tareas")
@Produces({ "application/json" })
public class ListaResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaResource.class);
	private final TareaDAO tareaDAO;

	public ListaResource(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	}

	@GET
	public Lista obtenerLista(@QueryParam("name") Optional<String> name) {
		LOGGER.info("ListaResource.obtenerLista");
		Subject s = SecurityUtils.getSubject();
		if (s.isAuthenticated()) {
			LOGGER.info("yay!");
		} else {
			LOGGER.info("nay!");
		}
		int codUsuario = 0;
		Lista lista = this.tareaDAO.obtenerLista(codUsuario);
		return lista;
	}

	@PUT
	public void grabarLista() {
		LOGGER.info("ListaResource.grabarLista");
	}

}