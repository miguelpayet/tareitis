package com.tareitis.lista;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/tareas")
@Produces({ "application/json" })
public class ListaResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListaResource.class);
	private final TareaDAO tareaDAO;

	public ListaResource(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	}

	@GET
	@Timed
	public Lista obtenerLista(@QueryParam("name") Optional<String> name) {
		LOGGER.info("ListaResource.obtenerLista");
		int codUsuario = 0;
		Lista lista = this.tareaDAO.obtenerLista(codUsuario);
		return lista;
	}

	@PUT
	@Timed
	public void grabarLista() {
	}
}